# Start from a base image with JDK
FROM openjdk:17-jdk-slim
# Copy the pre-built jar file into the container
COPY target/*.jar app.jar
# Command to run the application
RUN mkdir log
ENTRYPOINT ["java","-jar","/app.jar"]