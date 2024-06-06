# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim
LABEL authors="joaoa"

# Set the working directory in the container
WORKDIR /app/

# Install git
RUN apt-get update && apt-get install -y git && rm -rf /var/lib/apt/lists/*

# Clone the repository
RUN git clone https://bitbucket.org/pssmatos/gradle_basic_demo/

# Set the working directory to the cloned repository
WORKDIR /app/gradle_basic_demo/

# Make gradlew script executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Define the command to run the application
CMD ["java", "-cp", "build/libs/basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]
