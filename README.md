# QA Automation Framework

This project is a QA Automation framework for testing both web and API interfaces. It is built using Java, Maven, TestNG, Selenide, Rest-Assured, Allure, and Lombok.

## Technologies Used

*   **Java 17**: The core programming language.
*   **Maven**: For project management and build automation.
*   **TestNG**: As the testing framework.
*   **Selenide**: For UI test automation. It provides a concise API for interacting with web elements.
*   **Rest-Assured**: For API test automation.
*   **Allure**: For generating detailed test reports.
*   **Lombok**: To reduce boilerplate code in POJOs.

## Project Structure

The project follows a standard Maven layout:

```
.
├── src
│   ├── main
│   │   └── java
│   │       ├── baseEntities       # Base classes for tests and pages
│   │       ├── utils              # Utility classes like ApiEndpoints, Listener, ReadProperties
│   └── test
│       ├── java
│       │   ├── pages              # Page Objects for the web application
│       │   ├── steps              # Business logic steps for tests
│       │   ├── tests              # Test classes
│       │   │   ├── apiTests       # API tests
│       │   │   └── guiTests       # GUI (UI) tests
│       │   └── pojos              # Plain Old Java Objects for API requests/responses (e.g., LoginRequest, UserRequest)
│       └── resources
│           ├── allure.properties  # Allure configuration
│           ├── config.properties  # Project configuration (URLs, credentials, etc.)
│           └── testNG.xml         # TestNG suite configuration
├── pom.xml                        # Maven project configuration
└── README.md                      # This file
```

## How to Run the Tests

To run the tests, you can use the following Maven command:

```bash
mvn clean install
```

This will execute all the tests defined in the `testNG.xml` file.

### Generating the Allure Report

After running the tests, you can generate the Allure report with the following commands:

```bash
mvn allure:serve
```

This will generate the report and open it in your default browser.
