DEVOPS Class Assignment 3 Part 1 - Joao Vieira - Switch 1231835

## Table of Contents

1. [Setup](#setup)
2. [Cloning the Repository](#cloning-the-repository)
3. [Building and Executing Projects](#building-and-executing-projects)
4. [Conclusion](#conclusion)

## Setup

To start with this class assignment, there was the need to set up a virtual machine (VM) as described in the lecture. 

I followed these steps to prepare the VM:

1- Update the package list:
    ```bash
    sudo apt update
    ```

2- Install essential packages:
    ```bash
    sudo apt install bzip2 build-essential dkms linux-headers-$(uname -r)
    ```

3- Verify the installation of VirtualBox guest additions:
    ```bash
    lsmod | grep vboxguest
    ```

4- Install network tools:
    ```bash
    sudo apt install net-tools
    ```

5- Restart the VM:
    ```bash
    sudo shutdown now
    ```

6- Install Git:
    ```bash
    sudo apt install git
    ```

7- Install OpenJDK:
    ```bash
    sudo apt install openjdk-17-jdk-headless
    ```

## Cloning the Repository

Once the VM was set up, I cloned my individual repository inside the VM:

1- Navigate to a directory and clone the repository:
    ```bash
    git clone https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835.git
    ```

2- Navigate to the cloned repository:
    ```bash
    cd devops-23-24-JPE-JPM-1231835
    ```

## Building and Executing Projects

Next, I built and executed the Spring Boot tutorial basic project and the `gradle_basic_demo` project:

1- Navigate to the Spring Boot project directory:
    ```bash
    cd CA1/basic
    ```

2- Make the `mvnw` script executable through permitions and run the project:
    ```bash
    chmod u+x mvnw
    ./mvnw spring-boot:run
    ```

3- Navigate to the Gradle project directory:
    ```bash
    cd ../../CA2/Part1
    ```

4- Make the `gradlew` script executable and build the project:
    ```bash
    chmod u+x gradlew
    ./gradlew build
    ```

5- Navigate to react-and-spring-data-rest-basic part of the project and repeat the steps to build and run the projects:
    ```bash
    cd ../Part2/react-and-spring-data-rest-basic
    chmod u+x gradlew
    ./gradlew build
    ./gradlew bootRun
    ```

Executing the server inside the VM and clients on the host machine provides a controlled, isolated, and realistic environment for development, testing, and deployment, which enhances the overall quality and reliability of the application.


## Conclusion

In this assignment, I set up a virtual environment, cloned and built my individual repository projects, and executed them in a controlled VM environment.

I also accessed web applications from the host machine and ran server-client applications across the VM and host machine.

This setup provided me with a comprehensive understanding of working in isolated development environments and handling common issues that may arise.

By following these steps, I hope to have gained valuable experience in setting up and managing virtual environments, which is essential for modern DevOps practices.