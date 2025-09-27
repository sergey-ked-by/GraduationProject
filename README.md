# QA Automation Framework

[![Java CI with Maven and Docker](https://github.com/sergey-ked-by/tms-project/actions/workflows/maven-build.yml/badge.svg)](https://github.com/sergey-ked-by/tms-project/actions/workflows/maven-build.yml)

This project is a QA Automation framework for testing both web and API interfaces. It is built using Java, Maven, TestNG, Selenide, Rest-Assured, Allure, and Lombok.

The project is configured with a CI/CD pipeline using GitHub Actions that automatically builds, tests, and packages the application as a Docker image.

## Technologies Used

*   **Java 17**: The core programming language.
*   **Maven**: For project management and build automation.
*   **TestNG**: As the testing framework.
*   **Selenide**: For UI test automation.
*   **Rest-Assured**: For API test automation.
*   **Allure**: For generating detailed test reports.
*   **Lombok**: To reduce boilerplate code.
*   **Docker**: For containerizing the application.
*   **GitHub Actions**: For CI/CD automation.

## CI/CD Pipeline

The repository is equipped with a GitHub Actions workflow (`maven-build.yml`) that triggers on every push or pull request to the `master` branch. The pipeline performs the following steps:
1.  **Checkout**: Clones the repository.
2.  **Set up JDK**: Initializes the Java 17 environment.
3.  **Build & Test**: Compiles the code and runs all tests using `mvn -B install`.
4.  **Docker Build & Push**: Builds a Docker image using a multi-stage `Dockerfile` for a minimal image size and pushes it to the GitHub Container Registry (GHCR).

## How to Run

### Run Tests Locally

To run the tests, you can use the following Maven command:

```bash
mvn clean install
```

This will execute all the tests defined in the `testNG.xml` file.

### Run Application with Docker

A Docker image is automatically published to GHCR. You can run the application using the following command:

```bash
docker run -p 8080:8080 ghcr.io/sergey-ked-by/tms-project:latest
```
*Note: This assumes the application inside the container runs on port 8080. If it uses a different port, update the `-p` flag accordingly.*

### Generating the Allure Report

After running the tests, you can generate the Allure report with the following commands:

```bash
mvn allure:serve
```

This will generate the report and open it in your default browser.