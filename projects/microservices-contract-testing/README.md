# Project: Microservices Contract Testing

## Goal
Prevent integration breakages with producer/consumer contracts.

## Suggested Stack
- Pact (consumer and provider verification)
- CI job that verifies and publishes contracts

## Suggested Scenarios
- Required field contract
- Enum and schema evolution
- Backward compatibility for existing consumers

## Folder Template
```text
microservices-contract-testing/
├── consumer-tests/
├── provider-verification/
├── pact-files/
└── README.md
```
