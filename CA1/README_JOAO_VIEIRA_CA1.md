# Class Assignment 1 - DEVOPS - Joao Vieira 1231835

## Introduction

The goal of this class assignment was to introduce the concept of branches and merging, including messaged commits, creating and solving issues and understanding the overall interaction between the local and online repository

My assignment can be found [here](https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835).


## Table of Contents

1. [Getting Started](#Getting-started)
2. [Implementing Changes](#Implementing-Changes)
   - [Part 1: Addition of the job years field](#Part-1-Addition-of-the-job-years-field)
   - [Part 2: Addition of the email field](#Part-2-Addition-of-the-email-field)
   - [Part 3: Addition of the fix for invalid email](#Part-3-Addition-of-the-fix-for-invalid-email)
3. [Issues](#Issues)
4. [Alternative to Git: Perforce Helix Core](#Alternative-to-Git-Perforce-Helix-Core)
   - [Branches, Commits, Push and Pulls in Perforce Helix Core](#Branches,-Commits,-Push-and-Pulls-in-Perforce-Helix-Core)
   - [Useful commands for Perforce Helix Core](#Useful-commands-for-Perforce-Helix-Core)
5. [Final Remarks](#Final-Remarks)


## Getting Started

First thing I did was to clone [this repository](https://github.com/spring-guides/tut-react-and-spring-data-rest) to my local machine. Files that were not needed were deleted.

In my case I copied the files to the CA1 folder manually on windows.

Alternatively, it could have been done using these commands on git bash:

1. (Go to the project directory) + Copy the application into a new CA1 folder:
   ```bash
   cp -r . ../CA1
   cd ../CA1
   ```
2. Start the Git repository (if not already a Git repository):
   ```bash
   git init
   ```
3. Add all files to the staging area and commit them (while addind a message):
   ```bash
   git add .
   git commit -m "First Commit"
   ```
4. Push the commit to the remote repository:
   ```bash
   git remote add origin <https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835>
   git push -u origin master
   ```


### Implementing Changes
#### Part 1: Addition of the job years field

This first part of the Assignment was done on the main branch, with the goal to add the field 'jobYears' to the Employee Class (with all the changes that it implies):

1. Added the new field to the Employee Class as a private attribute (private int jobYears)
2. Added the new field to the Class's constructor
3. Added validations so that the parameters are always valid
4. Added getters and setters for the new attribute
5. Added the new field to the toString method, equals method and hashCode.
6. Added an Employee Test class and added unit tests for the new field
7. Added the new field to the render methods in the app.js Javascript file
8. Added the new field to the run method in the DatabaseLoader Class          
9. Ran the program (after navigating to the basic folder) and opened a browser to [http://localhost:8080](http://localhost:8080) to check if all was working accordingly:
```bash
./mvnw spring-boot:run
```
10. Added the changes to the staging area:
```bash
git add .
```
11. Commited the changes with a message:
```bash
git commit -m "Insertion of the attribute Job Years to the Employee Class, plus all the suplementary additions needed (such as in the constructor and on other methods that were dependant on it) and a method for validating parameters and the respective class test"
```
12. Pushed the changes to the remote repository:
```bash
git push
```
13. Added a tag to the commit:
```bash
git tag -a v1.2.0 -m "v1.2.0 Job Years attribute added to Employee Class, along with adjusment of all dependant method, and creation of the tests"
```
14. Added a tag as the end of the first part of the assignment:
```bash
git tag -a ca1-part1 -m "ca1-part1"
git push origin v1.2.0
git push origin ca1-part1 
```


#### Part 2: Addition of the email field

This part of the Assignment has the goal of creating a new branch so that the email field may be added to the Employee Class.

1. Created a new branch:
```bash
git branch email-field
```
2. Switched to the new branch:
```bash
git checkout email-field
```
3. Pushed the  new branch to the remote repository:
```bash
git push -u origin email-field
```
4. Added the new field to the Employee Class (private String eMail)
5. Added the new field to the Class's constructor
6. Added validations so that the parameters are always valid
7. Added getters and setters for the new attribute
8. Added the new field to the Class's toString method, equals method and hashCode
9. Created an Employee Test Class and its Unit Tests
10. Added the new field to the render methods in the app.js Javascript file:
11. Added the new field to the DatabaseLoader Class
12. Ran the program (after navigating to the basic folder) and opened a browser to [http://localhost:8080](http://localhost:8080) to check if all is working accordingly:
```bash
./mvnw spring-boot:run
```
13. Added the files that were changed to the staging area:
```bash
git add <filename>
```
14. Commited the changes with a message:
```bash
git commit -m "Added eMail attribute to the Employee class, adjusted all the methods related to it (such as the constructor), and added validations for the possibility of the email being null or empty. Also corrected unit tests and added tests for the new validations, getter and setter methods. At last, adjusted the DatabaseLoades class so that the run method also has the email"
git push
```
15. Switched back to the main branch:
```bash
git checkout main
```
16. Merged the email-field branch into the main branch:
```bash
git merge --no-ff email-field
```
17. Pushed the changes to the remote repository:
```bash
git push origin main
```
18. Added a messaged tag to the commit:
```bash
git tag -a v1.3.0 -m "E-mail field added with all the necessary adjustments and unit tests"
git push origin v1.3.0
```
19. Ammended last commit and forcefully pushed in order to close Issue #1 (which should have been done while commiting for the first time, and before merging):
```bash
git commit --amend -m "Merge branch email-field. Closes #1"
git push --force
```


#### Part 3: Addition of the fix for invalid email

This last part of the Assignemt had the goal of creating another, new branch, with the intent of fixing parameters for email validation

1. Created a new branch:
```bash
git branch fix-invalid-email
```
2. Switched to the new branch:
```bash
git checkout fix-invalid-email
```
3. Pushed the new branch to the remote repository:
```bash
git push -u origin fix-invalid-email
```
4. Updated the areParamsValid method in the Employee class so that an email that would be entered has a "@" character (!eMail.matches(".+@.+\\..+"))
5. Added the altered files to the staging area:
```bash
git add <filename>
```
6. Commited the changes and closed Issue #2:
```bash
git commit -m "Altered email validations so that does not accept without the @ sign. Closes #2"
git push
```
7. Switched to the main branch:
```bash
git checkout main
```
8. Merged the fix-email-field branch back into the main branch:
```bash
git merge --no-ff fix-invalid-email
```
9. Push the changes to the remote repository:
```bash
git push origin main
```
10. Add a new tag to the commit:
```bash
git tag -a v1.3.1 -m "Created validations so that the email has to have a @ sign"
git push origin v1.3.1
```
11. Add a tag to mark the end of the current assignment:
```bash
git tag -a ca1-part2 -m "ca1-part2 Finalized"
git push origin ca1-part2
```


### Issues

During the process of this assignment two Issues were created in order to create a direction of where the work flow should point to. As if it were a to-do list.

Firstly the "Add support for the email field" issue was created and then the "Fix invalid e-mail", as these were the two mains "things to do" in the second part of the assignment.

To create an Issue:
1. Went to the repository's main page
2. Clicked on the "Issues" tab
3. Clicked on the "New issue" button
4. Filled in the issue title and description and clicked on the "Submit new issue" button
5. Created an issue which was assigned a number (eg. #3)
6. Solved the issue by adding the comment "Fixes" or "Closes" on a commit message + the number of the Issue.
```java
git commit -m "Closes #2"
```
7. Clicked on the "Close Issue" button on GitHub after it noted there was a commit closing that exact issue number


### Alternative to Git: Perforce Helix Core

Perforce Helix Core is a centralized version control system. It means that there is a single server where the files are stored, and users check out files to work on them (Unlike GitHub, where every user has a complete copy of the repository, including its history, which allows for flexible workflows and offline work). It's known for its ability to handle very large codebases and binary files efficiently, which makes it a choice for large, enterprise-level projects, especially in industries like game development, automotive, and multimedia production, where projects involve a lot of binary data (like images, audio files, and 3D models).

#### Branches, Commits, Push and Pulls in Perforce Helix Core

In Perforce, branches are often managed through "branch specifications" or "streams." The approach to branching can be more structured than in Git, emphasizing a more controlled flow of changes. To create a Branch (Stream) the Perforce Visual Client (P4V) can be used or, instead, the command line with p4 stream to create a stream specification and p4 branch to define mappings between source and target paths.

Commit: The closest equivalent in Perforce is p4 submit, which submits changes from a local workspace to the Perforce server. This action is more akin to a combined Git commit + push, as it both commits changes and makes them available on the server.

Push: Since Perforce is centralized, the concept of pushing does not apply the same way it does in Git. The p4 submit command automatically "pushes" changes to the server.

Pull: The equivalent action in Perforce is p4 sync, which synchronizes the workspace with the latest files from the depot (repository) on the server. This command ensures it's working with the most current version of files.


##### Useful commands for Perforce Helix Core

p4 add: Mark files to be added to the depot.
p4 edit: Open an existing file for edit.
p4 delete: Mark a file for deletion from the depot.
p4 submit: Submit changes from your workspace to the depot.
p4 sync: Synchronize your workspace with the depot.
p4 integrate: Integrate changes from one branch into another.
p4 resolve: Resolve conflicts resulting from an integrate operation.
p4 revert: Discard changes in your workspace before submitting.
p4 branch: Create or edit a branch mapping specification.
p4 stream: Create or edit a stream.


### Final Remarks

As final remarks I must point out that this class assignment was quite joyful to do with the help of my colleagues during class hours and also the much appreciated help from teacher Paulo Matos specially when I ran into a problem with unversioned files.
During the whole process the two main areas to be accounted for future reference are:
1- The fact that I should have closed issue#1 before merging the first branch back into the main, which would allowed me not to have to write the commands 'git commit --amend -m "..."' and 'git push --force' to ammend and forcefully push the commit (which should not be done in a scenario where multiple people are working on the same repository).
2- The fact that I should have created Issues from the start and not only since the second part of the assignment. Issues help figure out what to do next and establish a route.
So, overall I think all went well and quite smoothly, apart from some bumps that were smoothed out along the way.
