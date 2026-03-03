#!/usr/bin/env bash
set -euo pipefail

# Usage:
#   GITHUB_USER=<username> ./scripts/split-portfolio-into-repos.sh
# Requirements:
#   - gh CLI authenticated
#   - run from repository root

if [[ -z "${GITHUB_USER:-}" ]]; then
  echo "Please set GITHUB_USER. Example: GITHUB_USER=johnqa ./scripts/split-portfolio-into-repos.sh"
  exit 1
fi

if ! command -v gh >/dev/null 2>&1; then
  echo "gh CLI not found. Install GitHub CLI first."
  exit 1
fi

workdir="$(pwd)/.tmp-publish"
rm -rf "$workdir"
mkdir -p "$workdir"

create_repo_from_path() {
  local repo_name="$1"
  local source_path="$2"

  local target="$workdir/$repo_name"
  mkdir -p "$target"

  cp -R "$source_path"/* "$target"/ 2>/dev/null || true

  if [[ ! -f "$target/README.md" ]]; then
    echo "# $repo_name" > "$target/README.md"
  fi

  pushd "$target" >/dev/null
  git init -q
  git checkout -b main >/dev/null 2>&1 || true
  git add .
  git commit -m "Initial QA portfolio import" >/dev/null
  gh repo create "$GITHUB_USER/$repo_name" --public --source . --remote origin --push >/dev/null
  popd >/dev/null

  echo "Published: https://github.com/$GITHUB_USER/$repo_name"
}

# Project repos
create_repo_from_path "qa-api-automation" "projects/api-test-automation"
create_repo_from_path "qa-ui-automation-playwright" "projects/ui-test-automation"
create_repo_from_path "qa-contract-testing-pact" "projects/microservices-contract-testing"
create_repo_from_path "qa-performance-k6" "projects/performance-testing"

# Handbook repo
mkdir -p "$workdir/qa-engineering-handbook"
cp README.md "$workdir/qa-engineering-handbook/README.md"
cp -R docs "$workdir/qa-engineering-handbook/"
cp -R templates "$workdir/qa-engineering-handbook/"
pushd "$workdir/qa-engineering-handbook" >/dev/null
git init -q
git checkout -b main >/dev/null 2>&1 || true
git add .
git commit -m "Initial QA engineering handbook" >/dev/null
gh repo create "$GITHUB_USER/qa-engineering-handbook" --public --source . --remote origin --push >/dev/null
popd >/dev/null
echo "Published: https://github.com/$GITHUB_USER/qa-engineering-handbook"

echo
echo "Next steps:"
echo "1) Create profile repo named exactly '$GITHUB_USER' and add profile README"
echo "2) Pin all 5 repos on your GitHub profile"
echo "3) Add CI badges and reports"
