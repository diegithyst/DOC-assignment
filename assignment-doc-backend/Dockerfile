# Use an official Maven image to build the application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project, skipping tests
RUN mvn -B package -DskipTests

# Use an official Alpine image with OpenJDK 19 JRE for the final image
FROM alpine:3.19

# Install OpenJDK 19 JRE
RUN apk add --no-cache openjdk19-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build image
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
