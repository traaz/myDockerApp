# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy your Spring Boot application jar file to the container
COPY target/demoProject-0.0.1-SNAPSHOT.jar mySpringApp

# Expose the port your app will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "mySpringApp"]