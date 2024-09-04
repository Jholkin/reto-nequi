FROM openjdk:21
LABEL authors="jholkin"

# the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8080

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx524M", "-jar", "/app.jar"]