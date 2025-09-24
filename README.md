# QA Automation Framework

[![Java CI with Maven and Docker](https://github.com/sergey-ked-by/tms-project/actions/workflows/maven-build.yml/badge.svg)](https://github.com/sergey-ked-by/tms-project/actions/workflows/maven-build.yml)

This project is a QA Automation framework for testing both web and API interfaces. It is built using Java, Maven, TestNG, Selenide, Rest-Assured, Allure, and Lombok.

The project is configured with a CI/CD pipeline using GitHub Actions that automatically builds, tests (inside a Docker container), and packages the application as a Docker image.

## Technologies Used

*   **Java 17**: The core programming language.
*   **Maven**: For project management and build automation.
*   **TestNG**: As the testing framework.
*   **Selenide**: For UI test automation.
*   **Rest-Assured**: For API test automation.
*   **Allure**: For generating detailed test reports.
*   **Lombok**: To reduce boilerplate code.
*   **Docker**: For containerizing the application and running tests in an isolated environment.
*   **GitHub Actions**: For CI/CD automation.

## CI/CD Pipeline

The repository is equipped with a GitHub Actions workflow (`maven-build.yml`) that triggers on every push or pull request to the `master` branch. The pipeline performs the following steps:

1.  **Checkout**: Clones the repository.
2.  **Set up JDK**: Initializes the Java 17 environment.
3.  **Run Tests in Docker**: Builds a temporary Docker image (`builder` stage) which runs all tests using `mvn test`. This ensures a consistent and isolated testing environment.
4.  **Copy Test Results**: Copies the `allure-results` from the temporary Docker container to the CI runner.
5.  **Generate & Upload Allure Report**: Generates the Allure report from the results and uploads it as a build artifact.
6.  **Login to GHCR**: Authenticates to the GitHub Container Registry.
7.  **Build & Push Final Image**: Builds the final, lightweight Docker image for the application and pushes it to the GitHub Container Registry (GHCR).

## How to Run

### Build and Run Tests

The primary and most reliable way to run the tests is by using the Dockerfile, as this replicates the CI environment exactly.

```bash
# This command builds the 'builder' stage of the Dockerfile, running all tests inside the container.
docker build --target builder .
```

#### Alternative: Run Tests Locally with Maven

For local development, you can still run the tests directly using Maven. This is faster but does not provide the same level of isolation as Docker.

```bash
mvn clean test
```

### Run the Application

A Docker image is automatically published to GHCR after a successful build on the `master` branch. You can run the application using the following command:

```bash
docker run -p 8080:8080 ghcr.io/sergey-ked-by/tms-project:latest
```
*Note: This assumes the application inside the container runs on port 8080. If it uses a different port, update the `-p` flag accordingly.*

### Generating the Allure Report

After running the tests (either with Docker or Maven), you can generate and view the Allure report with the following command:

```bash
mvn allure:serve
```

This will use the contents of the `target/allure-results` directory to generate the report and open it in your default browser.
