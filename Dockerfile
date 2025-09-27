# --- Stage 1: Build the project (Builder) ---
# Use the official Maven image with JDK 17 to build our project.
# This is a temporary stage; its only result is the compiled .jar file.
FROM maven:3.9-eclipse-temurin-17 AS builder

# Set the working directory inside the container.
WORKDIR /app

# Copy pom.xml to leverage Docker's layer caching for dependencies.
# If pom.xml hasn't changed, Docker won't re-download the dependencies.
COPY pom.xml .

# Download all project dependencies.
RUN mvn dependency:go-offline

# Copy the rest of the project's source code.
COPY src ./src

# Build the project and create the .jar file. Skip tests as they should have already run in a previous CI step.
# The 'package' command creates the jar in the /target directory.
RUN mvn package -DskipTests

# --- Stage 2: Create the final image (Final Stage) ---
# Use a minimal image with only the Java Runtime Environment (JRE) to make the final image as small as possible.
FROM eclipse-temurin:17-jre-jammy

# Set the working directory.
WORKDIR /app

# Copy ONLY the compiled .jar file from the 'builder' stage into our final image.
# We rename it to app.jar for convenience.
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the application will run on.
# REPLACE 8080 if your application uses a different port.
EXPOSE 8080

# The command that will be executed when the container starts.
# Runs our Java application.
ENTRYPOINT ["java", "-jar", "app.jar"]