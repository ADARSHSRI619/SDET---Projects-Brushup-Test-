# Project: Performance Testing

## Goal
Detect regressions in latency and stability before release.

## Suggested Stack
- k6 scripts
- Baseline thresholds (p95, error rate)
- Artifact export for trend tracking

## Suggested Scenarios
- Home page/API baseline (constant VUs)
- Spike and stress profile for checkout/search
- Endurance mini-run for memory/leak indicators

## Folder Template
```text
performance-testing/
├── scripts/
├── data/
├── reports/
└── README.md
```
