# REST API Automation Framework (Java + Rest Assured + TestNG)

Production-grade REST API automation framework using **Java**, **Maven**, **Rest Assured**, and **TestNG** with:

- Base API client abstraction
- Reusable request specification builder
- Response validation utilities
- JSON schema validation
- Request/response logging via Log4j2
- Allure reporting integration
- Environment-based configuration through properties

## Tech Stack

- Java 17
- Maven 3.9+
- Rest Assured 5
- TestNG 7
- Log4j2
- Allure TestNG + Allure Rest Assured

## Folder Structure

```text
.
├── pom.xml
├── testng.xml
├── src
│   ├── main
│   │   └── java/com/framework
│   │       ├── config/ConfigReader.java
│   │       └── api
│   │           ├── builder/RequestSpecBuilderFactory.java
│   │           ├── client/
│   │           │   ├── BaseApiClient.java
│   │           │   └── UserApiClient.java
│   │           ├── filters/RequestResponseLoggingFilter.java
│   │           └── utils/
│   │               ├── ResponseValidator.java
│   │               └── SchemaValidatorUtil.java
│   └── test
│       ├── java/com/framework/api
│       │   ├── base/BaseApiTest.java
│       │   └── tests/UserApiCrudTest.java
│       └── resources
│           ├── config/config.properties
│           ├── schemas/get-user-schema.json
│           └── log4j2.xml
```

## Configuration

Set environment values in:

`src/test/resources/config/config.properties`

Default keys:

- `environment`
- `api.base.url`
- `connect.timeout.ms`
- `read.timeout.ms`

You can override any property through JVM args:

```bash
mvn test -Dapi.base.url=https://your-host/api
```

## Test Coverage (Sample)

`UserApiCrudTest` includes:

- GET `/users/{id}`
- POST `/users`
- PUT `/users/{id}`
- DELETE `/users/{id}`

## Execute Tests

Run full suite (parallel methods via TestNG XML):

```bash
mvn test
```

## Reporting

Allure results are generated under:

`target/allure-results`

Generate and open report:

```bash
mvn allure:report
mvn allure:serve
```

## Logging

Request/response logs are captured through custom Rest Assured filter and Log4j2.

Log file:

`target/logs/api-automation.log`

## Notes

If Maven dependency/plugin downloads are blocked in your environment, configure a reachable mirror in Maven `settings.xml`.
