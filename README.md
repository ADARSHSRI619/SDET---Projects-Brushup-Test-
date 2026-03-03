# Selenium Automation Framework (Java + Maven + TestNG)

Production-grade UI test automation framework following **Page Object Model (POM)** with support for:

- Thread-safe WebDriver lifecycle using `ThreadLocal`
- TestNG parallel execution
- Explicit wait utilities with `WebDriverWait`
- Allure reporting
- Log4j2 logging
- Environment-driven configuration through `.properties`

## Tech Stack

- Java 17
- Maven
- Selenium WebDriver 4
- TestNG 7
- WebDriverManager
- Allure TestNG
- Log4j2

## Project Structure

```text
.
├── pom.xml
├── testng.xml
├── src
│   ├── main
│   │   └── java/com/framework
│   │       ├── config/ConfigReader.java
│   │       ├── driver/DriverFactory.java
│   │       ├── pages/
│   │       │   ├── BasePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── FormPage.java
│   │       │   └── DynamicTablePage.java
│   │       └── utils/WaitUtils.java
│   └── test
│       ├── java/com/framework
│       │   ├── base/BaseTest.java
│       │   └── tests/
│       │       ├── LoginTest.java
│       │       ├── FormSubmissionTest.java
│       │       └── DynamicTableTest.java
│       └── resources
│           ├── config/config.properties
│           └── log4j2.xml
```

## Setup

1. Install Java 17+ and Maven 3.9+.
2. Clone the repository.
3. Install dependencies:

```bash
mvn clean install -DskipTests
```

## Configuration

Update `src/test/resources/config/config.properties`:

- `environment` - execution environment label
- `browser` - `chrome`, `firefox`, `edge`
- `headless` - `true/false`
- `implicit.wait.seconds`, `explicit.wait.seconds`
- `app.base.url`, `app.form.url`
- `app.username`, `app.password`

You can override properties via JVM system properties. Example:

```bash
mvn test -Dbrowser=firefox -Dheadless=false
```

## Run Tests

Run the full parallel suite:

```bash
mvn test
```

Run a specific test class:

```bash
mvn test -Dtest=LoginTest
```

## Allure Reporting

Generate and serve Allure report:

```bash
mvn allure:report
mvn allure:serve
```

Allure results are generated under `target/allure-results`.

## Logging

Log4j2 configuration is available at `src/test/resources/log4j2.xml`.

Execution logs are written to:

- Console output
- `target/logs/automation.log`

## Sample Test Coverage

- `LoginTest` - validates login flow and success message
- `FormSubmissionTest` - validates form submission and confirmation message
- `DynamicTableTest` - validates dynamic table row presence and expected content
