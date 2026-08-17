# Selenium Java TestNG POM Automation Framework

A small but interview-ready UI automation framework built with:

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Page Object Model (POM)
- Selenium Manager for browser driver management

## Application under test

This project automates the public Sauce Demo practice application:

https://www.saucedemo.com/

Standard test credentials:

- Username: `standard_user`
- Password: `secret_sauce`

## Project structure

```text
selenium-java-testng-pom/
├── pom.xml
├── testng.xml
├── README.md
└── src
    ├── main
    │   └── java
    │       ├── base
    │       │   └── BasePage.java
    │       ├── config
    │       │   └── ConfigReader.java
    │       ├── driver
    │       │   └── DriverFactory.java
    │       ├── pages
    │       │   ├── LoginPage.java
    │       │   ├── InventoryPage.java
    │       │   └── CartPage.java
    │       └── utils
    │           └── ScreenshotUtils.java
    └── test
        └── java
            ├── base
            │   └── BaseTest.java
            └── tests
                ├── LoginTest.java
                └── ProductTest.java
```

## Scenarios automated

1. Successful login
2. Invalid login validation
3. Product sorting by price
4. Add product to cart
5. Verify cart contents

## Run locally

Prerequisites:

- JDK 17+
- Maven 3.9+
- Chrome installed

Run:

```bash
mvn clean test
```

Selenium Manager automatically resolves the appropriate browser driver.

## Design decisions

### Page Object Model
Locators and page actions are kept inside page classes. Test classes contain business-level test flows and assertions.

### DriverFactory
Centralizes WebDriver creation and makes browser setup easier to extend later for Firefox/Edge or remote execution.

### BaseTest
Owns test setup/teardown so individual test classes remain clean.

### ConfigReader
Reads runtime configuration from Java system properties with sensible defaults.

Example:

```bash
mvn clean test -Dbrowser=chrome -DbaseUrl=https://www.saucedemo.com/
```

## GitHub presentation tips

Add the following to the repository after your first run:

- A screenshot of a passing TestNG/Maven run
- A GitHub Actions workflow
- A short test execution GIF or screenshot
- A meaningful commit history
- A README with architecture and scenarios

This makes the repository look like a real automation project rather than a code dump.
