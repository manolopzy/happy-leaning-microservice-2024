FROM openjdk:21-jdk-oracle
MAINTAINER zhenyi
ARG JAVA_OPTS="-Xmx128M"
ENV JAVA_OPTS=$JAVA_OPTS
#The --spring.profiles.active flag is used to activate specific profiles for a Spring Boot application. This flag can be passed as a command-line argument when running the application. It allows you to dynamically switch between different profiles, which can be defined in the application configuration files (e.g., application.properties or application.yml)
#When you run your application with --spring.profiles.active=prod, it will activate the prod profile, in addition to any profiles that are already activated by default (as defined in the application configuration files). For example, if you have a default profile named default and a profile named proddb, running with --spring.profiles.active=prod will activate both prod and proddb profiles.

#Here’s a breakdown of how it works:

#By default, Spring Boot applications come with a primary profile (e.g., default).
#You can define additional profiles in your application configuration files (e.g., application.properties or application.yml).
#The spring.profiles.active property is used to specify which profiles to activate. You can set this property in your configuration files or pass it as a command-line argument using --spring.profiles.active.
#When you activate a profile using spring.profiles.active, Spring Boot will load the configuration files and beans specific to that profile.
ARG RUN_ARGS="--spring.profiles.active=prod"
ENV RUN_ARGS=$RUN_ARGS
#docker run -p 8080:8080 my-image
#This specifies that the container listens on port 8080.
EXPOSE 8099
# ADD target/gateway-0.0.1-SNAPSHOT.jar /gateway.jar
# Copy the spring boot jar
COPY target/*.jar happylearning-serviceregistry.jar
# Run the command to start the spring boot application
#In a Dockerfile, you can only have one ENTRYPOINT instruction. 
#If you repeat it, the last one will override the previous ones.
#CMD, on the other hand, provides default arguments to the ENTRYPOINT. 
#When you run a container without specifying a command, 
#Docker uses the CMD value as the default. However, 
#you can override CMD by passing a different command when starting 
#the container.
# CMD ["java", "-jar", "happylearning-gateway.jar"]
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /happylearning-serviceregistry.jar $RUN_ARGS"]
