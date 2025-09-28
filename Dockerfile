# Use an image that includes Maven, JDK 17, and Chrome
FROM markhobson/maven-chrome:jdk-17

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml to download dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the entire source code of the project
COPY src ./src

# Run tests during the build for CI validation
RUN mvn test

# Set the default command to run tests when the container starts
CMD ["mvn", "test"]
