# QA Strategy (Sample)

## Objectives
- Protect critical user journeys and revenue paths.
- Shift-left with contract and API-level validation.
- Keep end-to-end tests lean and deterministic.

## Test Pyramid Allocation
- Unit / component checks: 65%
- API / integration checks: 25%
- End-to-end UI checks: 10%

## Quality Gates
1. Pull Request gate:
   - Static checks + smoke API tests
2. Merge-to-main gate:
   - Full API suite + critical UI regression
3. Release gate:
   - Performance sanity + release readiness checklist

## Defect Management Flow
- Severity and priority matrix maintained in triage board
- Defect SLA:
  - Sev-1: immediate triage, hotfix path
  - Sev-2: same day
  - Sev-3/4: planned backlog

## Core Metrics
- Escaped defects by severity
- Automation pass rate trend
- Mean time to detect (MTTD)
- Mean time to resolve (MTTR)
