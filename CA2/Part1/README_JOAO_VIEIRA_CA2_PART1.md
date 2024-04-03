# Class Assignment 2 Part 1 Joao Vieira 1231835 Switch

## Introduction

This class assignment's main goal was to introduce new features on a basic gradle application.

The assignment can be found [here](https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835).

## Table of Contents

1. [First Steps](#First-Steps)
2. [Implementation](#Implementation)
    - [1: Addition of the runServer task](#1-Addition-of-the-runServer-task)
    - [2: Addition of test class and unit test](#2-Addition-of-the-test-class-and-unit-test)
    - [3: Addition of the Copy task](#3-Addition-of-the-Copy-task)
    - [4: Addition of the Zip task](#3-Addition-of-the-Zip-task)
3. [Issues](#Issues)


## First Steps

The first step was to clone [this repository](https://bitbucket.org/pssmatos/gradle_basic_demo/).

After that, I used this commands in Git Bash through the IDE's terminal:

1. Went to the project's directory
2. Copied the application into a new CA2/Part1 folder
   ```bash
   cp -r . ../CA2/Part1
   ```

3. Started the Git repository:
   ```bash
   git init
   ```

4. Added all (.) files to the staging area, commited (with a message) and pushed to the remote repository
   ```bash
   git add .
   git commit -m "Added a new task to execute a server. Fixes #4"
   git push
   ```

### Implementation
#### 1: Addition of the runServer task

The goal of this first part of the implementation was to add a task to run the server. The task to run the client was already implemented.

I went to the build.gradle file and added the following at the end:

   ```gradle
   task runServer(type: JavaExec, dependsOn: classes) {
    group = "DevOps"
    description = "Launches the chat server on a specified port"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    // Port number on which the server should listen./gradlew build
    // Port number can be changed to any port other than '59001' if needed
    args 'localhost', '59001'
}

    ```


#### 2: Addition of the test class and unit test

As the second part of the assignment, a new test class was created with a unit test.

The steps were:

1. Created a new folder for the test within the IDE
2. Filled the test class with the unit test given by the example:
```java
package basic_demo;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

@Test
public void testAppHasAGreeting() {
    App classUnderTest = new App();
    assertNotNull("app should have a greeting", classUnderTest.getGreeting());
}
}
```

3. Added the dependencies in the build.gradle file:
```gradle
dependencies {
    // Use Apache Log4J for logging
    implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
    testImplementation 'junit:junit:4.12'
}
```

4. Compiled the project to check everything was running as it should:
```bash
./gradlew build
```

5. Added the changes to the staging area, commited them with a message and pushed them to the remote repository:
```bash
git add .
git commit -m "Added a Unit Test for the AppClass and updated the gradle script so that it could run. Fixes #5"
git push
```

#### 3: Addition of the Copy task

As the third part of the assignment, the aim was to create a new task that would create a backup of the source of the application into a 'backup' folder. 

The steps were:

1. Added a new task to the build.gradle file:
```gradle
task backupSources(type: Copy) {
    description = 'Backs up the source code to a backup directory'
    group = 'Backup'

    from 'src'
    into 'backup'
}
```

2. Compiled the project to check everything was running as it should:
```bash
./gradlew build
```

3. Added the changes to the staging area, commited them with a message and pushed them to the remote repository:
```bash
git add .
git commit -m "Add a new task of type Copy to be used to make a backup of the sources of the application. Fixes #6"
git push
```

#### 4: Addition of the Zip task

As the fourth and final part of the assignment, the aim was to create a new task that would create a .zip backup of the source of the application.

The steps taken were:

1. Added a new task to the build.gradle file:
```gradle
task archiveSources(type: Zip) {
    archiveFileName = 'sourceArchive.zip'

    from 'src'
}
```
2. Compiled the project to check everything was running as it should:
```bash
./gradlew build
```

3. Added the changes to the staging area, commited them with a message and pushed them to the remote repository:
```bash
git add .
git commit -m "Add a new task of type Zip to make an archive of the sources of the application. Fixes #7"
git push
```

4. Added a tag for the end of the first part of this second assignment:
```bash
git tag ca2-part1
git push origin ca2-part1
```

### Issues

Several Issues were made during this process in order to direct the work flow, as if it were a to-do list

Issues created were:

1. Creation of CA2/Part1 Folder and Commit of example Gradle App (#3)
2. Add a new Task to execute the server (#4)
3. Add a simple unit test and update the gradle script so that it is able to execute the test. (#5)
4. Add a new task of type Copy to be used to make a backup of the sources of the application. (#6)
5. Add a new task of type Zip to be used to make an archive or the src (#7)
6. Creation of the readMe file (#8)
