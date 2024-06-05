# Official OpenJDK 17 slim image as the base image.
# This provides the JDK runtime environment required for running Java applications.
FROM openjdk:17-jdk-slim

# Sets the working directory to /app.
# All subsequent commands will be executed from this directory.
WORKDIR /app

# Copies the pre-built JAR file from the local machine to the /app/dist directory in the container.
# This step transfers the compiled Java application into the Docker container.
COPY ./react-and-spring-data-rest-basic/build/libs/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.jar ./dist/

# Lists the files in the dist directory to verify the JAR file is in place.
# This helps in debugging and ensures the file was copied correctly.
RUN ls -la dist

# Exposes port 8080 to allow external access to the application running inside the container.
# This informs Docker that the container will listen on this network port at runtime.
EXPOSE 8080

# Defines the command to run the JAR file when the container starts.
# This command starts the Java application.
CMD ["java", "-jar", "dist/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.jar"]








