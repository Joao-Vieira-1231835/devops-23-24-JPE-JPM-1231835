FROM tomcat:10.1.24-jdk17-temurin-jammy
LABEL authors="joaoa"

# Remove the default ROOT webapp in order to avoid problems
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file from the CA2 to the webapps directory
COPY ./*.war /usr/local/tomcat/webapps/

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]