#!/usr/bin/env bash
set -euo pipefail

required_paths=(
  "README.md"
  "docs/github-profile-setup.md"
  "docs/qa-strategy.md"
  "docs/test-architecture.md"
  "docs/release-readiness-checklist.md"
  "roadmap/90-day-qa-upskilling-plan.md"
  "profile/README-template.md"
  "projects/api-test-automation/README.md"
  "projects/ui-test-automation/README.md"
  "projects/microservices-contract-testing/README.md"
  "projects/performance-testing/README.md"
  "templates/bug-report/bug-report-template.md"
  "templates/test-plan/test-plan-template.md"
  "templates/test-case/test-case-template.md"
  ".github/workflows/qa-quality-gate.yml"
  "scripts/split-portfolio-into-repos.sh"
)

missing=0
for path in "${required_paths[@]}"; do
  if [[ ! -f "$path" ]]; then
    echo "Missing: $path"
    missing=1
  fi
done

if [[ "$missing" -eq 1 ]]; then
  echo "Portfolio health check failed."
  exit 1
fi

echo "Portfolio health check passed."
