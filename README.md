# QA Engineer Portfolio (Built to Reflect on GitHub Profile)

If your profile currently looks empty, this repository now includes a **publish strategy** so it actually appears on your GitHub publicly.

## What was improved
- Structured QA content (strategy, architecture, release readiness)
- Four project tracks (API, UI, contract, performance)
- Reusable QA templates
- Profile README starter (`profile/README-template.md`)
- Publish helper script (`scripts/split-portfolio-into-repos.sh`)
- Step-by-step guide to make profile visible (`docs/github-profile-setup.md`)

## Quick Start (important)
1. Follow setup steps in `docs/github-profile-setup.md`.
2. Create your profile repository named exactly as your username.
3. Use `profile/README-template.md` as your profile bio content.
4. (Optional) Use script to split and publish portfolio repos:
   ```bash
   GITHUB_USER=<your_github_username> ./scripts/split-portfolio-into-repos.sh
   ```
5. Pin the published repositories on your profile.

## Portfolio Structure
```text
.
├── docs/
│   ├── github-profile-setup.md
│   ├── qa-strategy.md
│   ├── test-architecture.md
│   └── release-readiness-checklist.md
├── profile/
│   └── README-template.md
├── projects/
│   ├── api-test-automation/
│   ├── ui-test-automation/
│   ├── microservices-contract-testing/
│   └── performance-testing/
├── templates/
│   ├── bug-report/
│   ├── test-plan/
│   └── test-case/
└── scripts/
    ├── portfolio-health-check.sh
    └── split-portfolio-into-repos.sh
```

## Notes for Recruiter Impact
- Keep repos public and pinned.
- Add CI badges, test reports, screenshots, and release tags.
- Push small but regular commits each week to keep your activity graph alive.
