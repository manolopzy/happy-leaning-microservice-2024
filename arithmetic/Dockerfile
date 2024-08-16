FROM openjdk:17-jdk-oracle
MAINTAINER zhenyi
ARG JAVA_OPTS="-Xmx128M"
ENV JAVA_OPTS=$JAVA_OPTS
ARG RUN_ARGS="--spring.profiles.active=dev"
ENV RUN_ARGS=$RUN_ARGS
#docker run -p 8080:8080 my-image
#This specifies that the container listens on port 8080.
EXPOSE 8081
# ADD target/arithmetic-0.0.1-SNAPSHOT.jar /arithmetic.jar
# Copy the spring boot jar
COPY target/*.jar happylearning-arithmetic.jar
# Run the command to start the spring boot application
#In a Dockerfile, you can only have one ENTRYPOINT instruction. 
#If you repeat it, the last one will override the previous ones.
#CMD, on the other hand, provides default arguments to the ENTRYPOINT. 
#When you run a container without specifying a command, 
#Docker uses the CMD value as the default. However, 
#you can override CMD by passing a different command when starting 
#the container.
# CMD ["java", "-jar", "happylearning-gateway.jar"]
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /happylearning-arithmetic.jar $RUN_ARGS"]
