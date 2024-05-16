# DEVOPS Class Assignment 3 Part 2
# Joao Vieira - Switch 1231835


# Table of Contents

1. [Setup](#Setup)
2. [Implementation](#Implementation)
3. [Running Vagrant Up Command](#Running-Vagrant-Up-Command)
4. [Alternative implementation](#Alternative-implementation)
5. [Conclusion](#Conclusion)


## Setup

The first steps to start the class assignment were to download vagrant from its official website and to make my repository public (In the online repositor in GitHub, navigate to Settings, then to 'Danger Zone' on the bottom of the page and finally on 'Change Visibility').

After that, the following steps were taken:

1- Navigated to a place on my computer (using PowerShell) and cloned the BitBucket repository:

```bash
	git clone https://bitbucket.org/pssmatos/vagrant-multi-spring-tut-demo.git
```

2- Copied locally the vagrant file from the cloned repository to the CA3/Part2 folder



## Implementation

Inside the vagrant file, some changes needed to be addressed in order to correctly execute the 'vagrant up' command further down the road

The changes made were:

- config.vm.box changed to "generic/ubuntu2204"
  - Update needed for both the database and web server virtual machines (VMs), in order to use a more recente version of Ubuntu

- Java version changed to "openjdk-17-jdk-headless"
  - Update needed so that the Java version would be compatible with Tomcat

- H2 Database version changed to "h2-2.2.224.jar"
  - Update needed to be compatible with the Java version, as well as being a more recente version of H2

- Tomcat version to "10.1.23"
  - Update needed in order to have a more recente version of Tomcat

- Clone my own repository instead of the teacher's:

```bash
	git clone https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835.git
     	cd devops-23-24-JPE-JPM-1231835/CA2/Part2/react-and-spring-data-rest-basic
      	chmod u+x gradlew
      	./gradlew clean build
```

- In order to deploy the war file to Tomcat the following was done:

```bash
      sudo cp ./build/libs/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.war /opt/tomcat/webapps
      cd
      cd /opt/tomcat/bin
      ./startup.sh
```

After this modification to the vagrant file, I went back to CA2's react-and-spring-data-rest-basic

In there, made changes to:

1- build.grade:
- Added 'id 'war'' to the plugins
  - This enabled the application to be packaged as a Web Application Archive (WAR) file for deployment on a servlet container (Tomcat).
- Added to the dependencies 'providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat''
  - This included libraries necessary for deploying the application as a WAR file on Tomcat.


2- application.properties:
- Added the same as it was on the teacher's [example](https://bitbucket.org/pssmatos/tut-basic-gradle/src/master/src/main/resources/application.properties)
	- This was made in order to configure the application's connection to the H2 database (including setting the context path, configuring the base path for the Rest API endpoints, specifying the database, connection URL, and enabling the H2 web console).

3- app.js:
- Changed the componentDidMount method as it was on the teacher's [example](https://bitbucket.org/pssmatos/tut-basic-gradle/src/master/src/main/js/app.js)
	- This updated the path used by a React component to fetch data from the Spring Data REST API endpoint.

Also, added the SerletInitializer as it was in the teacher's [example](https://bitbucket.org/pssmatos/tut-basic-gradle/src/master/src/main/java/com/greglturnquist/payroll/ServletInitializer.java). This was created to configure the Spring application to run on a
servlet container, in this case Tomcat.


## Running Vagrant Up Command

Finally, the Vagrantfile was used to set up two virtual machines (one serving as a web server and the other dedicated to the database)

Through a web browser, the operation was confirmed as working. 

The commands used were:

1- Run the Vagrant Up command:

```bash
  vagrant up
```

2- Checked that the virtual machines were up and running:

```bash
  vagrant status
```

3- Accessed the H2 database via a web browser.
This allows for browsing the database and executing SQL queries.

```browser
http://192.168.56.10:8080/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT/h2-console"
```

Here is a print screen of the H2 Database Console running:
![Image](./ca3part2-2-db.jpg "H2 Database Console running")


4- To confirm the data within the database:

```browser
http://192.168.56.10:8080/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT/
```

Here is a print screen of the application running on the web server VM:
![Image](./ca3part2-1-db.jpg "App running on the web server VM")


In order to clean up the whole process, the vagrant folder must be deleted vagrant folder, and the following command should be used:

```bash
  vagrant destroy -f
```

IMPORTANT:
In the application.properties from react-and-spring-data-rest-basic in CA2, the lines are mostly commented so that CA2 can run.
To Run CA3 Part 2 in order to deploy Vagrant Up the whole application.properties file MUST be uncommented.

## Alternative Implementation

For an alternative implementation, Hyper-V can be used instead of VirtualBox. Hyper-V is a virtualization technology
built into Windows, offering robust performance and integration with the Windows operating system.

- Changes to the Vagrantfile:

  - To modify the Vagrantfile to work with Hyper-V, the provider configuration
  needs to be adjusted. Here’s how the modified Vagrantfile would look like:

```ruby
# See: https://manski.net/2016/09/vagrant-multi-machine-tutorial/
# for information about machine names on private network
Vagrant.configure("2") do |config|
config.vm.box = "generic/ubuntu2204"

# This provision is common for both VMs
config.vm.provision "shell", inline: <<-SHELL
sudo apt-get update -y
sudo apt-get install -y iputils-ping avahi-daemon libnss-mdns unzip \
openjdk-17-jdk-headless
SHELL

# Configurations specific to the database VM
config.vm.define "db" do |db|
db.vm.box = "generic/ubuntu2204"
db.vm.hostname = "db"
db.vm.network "private_network", ip: "192.168.56.11"

    db.vm.network "forwarded_port", guest: 8082, host: 8082
    db.vm.network "forwarded_port", guest: 9092, host: 9092

    db.vm.provision "shell", inline: <<-SHELL
      wget https://repo1.maven.org/maven2/com/h2database/h2/2.2.224/h2-2.2.224.jar
    SHELL

    db.vm.provision "shell", :run => 'always', inline: <<-SHELL
      java -cp ./h2*.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -ifNotExists > ~/out.txt &
    SHELL
end

# Configurations specific to the webserver VM
config.vm.define "web" do |web|
web.vm.box = "generic/ubuntu2204"
web.vm.hostname = "web"
web.vm.network "private_network", ip: "192.168.56.10"

    web.vm.provider "hyperv" do |h|
      h.memory = 1024
      h.cpus = 2
    end

    web.vm.network "forwarded_port", guest: 8080, host: 8080

    web.vm.provision "shell", inline: <<-SHELL, privileged: false
      sudo mkdir /opt/tomcat/
      cd /tmp
      wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.23/bin/apache-tomcat-10.1.23.tar.gz
      sudo tar xzvf apache-tomcat-10*tar.gz -C /opt/tomcat --strip-components=1
      sudo chmod -R u+x /opt/
      sudo chmod -R 777 /opt/tomcat

      git clone https://github.com/Joao-Vieira-1231835/devops-23-24-JPE-JPM-1231835.git
      cd devops-23-24-JPE-JPM-1231835/CA2/Part2/react-and-spring-data-rest-basic
      chmod u+x gradlew
      ./gradlew clean build
      sudo cp ./build/libs/react-and-spring-data-rest-basic-0.0.1-SNAPSHOT.war /opt/tomcat/webapps
      cd
      cd /opt/tomcat/bin
      ./startup.sh
    SHELL
  end
end
```

Key Adjustments:

- Provider Configuration:

  - Changed the provider for the web VM from virtualbox to hyperv.
  Set memory and CPU configurations specifically for Hyper-V.
  
- Compatibility:

    - Ensured all commands and settings are compatible with the Hyper-V provider.
By using Hyper-V, you can leverage the built-in virtualization capabilities of Windows, providing an efficient and integrated alternative to VirtualBox. This approach demonstrates the flexibility of Vagrant in working with different virtualization providers.

This implementation was not carried out, but it is a viable alternative to using VirtualBox for virtualization.

## Conclusion

In this assignment, I successfully utilized Vagrant to set up a virtual environment for deploying a web application. 

By following a structured approach, I was able to deploy the application and verified its functionality through a web browser. 

The goal of using Vagrant was to create a consistent and reproducible development environment, which was achieved. 

Vagrant's ability to manage virtual machine environments simplifies the process of setting up and tearing down development environments, ensuring that all team members work in a consistent setup.

Overall, this assignment provided hands-on experience with Vagrant and demonstrated its utility in managing complex development environments. The skills and knowledge gained from this exercise will be invaluable in future DevOps and development projects.








