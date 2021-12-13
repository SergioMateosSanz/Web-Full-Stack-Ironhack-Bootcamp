# How to **dockerize** a Spring Boot app 🐳

Quick guide on how to dockerize a very simple Spring Boot app with one endpoint that returns a static message.

## Build image 📷

0. Create an executable jar file of your app running ```mvn package```
1. Create a file name *Dockerfile* with the following content:

````
FROM openjdk:16-alpine3.13

COPY target/spring-boot-docker-0.0.1-SNAPSHOT.jar spring-boot-docker.jar

ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]

````
**FROM** tells Docker what base image we want to use for our app. Here we'll be using the official openjdk image 
from Docker Hub with Java JDK and Alpine.

**COPY** is used to copy new files to the Docker image This command takes 2 parameters. The first one tells Docker what file you want to copy into 
the image. The second one tells Docker where you want said file to be copied to.

**ENTRYPOINT** identifies the executable for the image

2. Run ```docker build --tag spring-boot-docker:demo .``` to build a Docker image from our Dockerfile
Flag --tag is used to set the name of the image and an optional tag with the following format: 
````docker build --tag image-name:image-tag .````
The ```.``` defines the location of our Dockerfile in the current directory.


![docker-image](https://github.com/gemasegarra/dockerize-springboot/blob/master/images/01.png)

## Run Docker image as a container 📦

To run the image inside a container, use ```docker run --name spring-demo -p 8080:8080 spring-boot-docker``` 

And we're ready! 🥳

![docker-container](https://github.com/gemasegarra/dockerize-springboot/blob/master/images/03.png)


### Documentation 📖

For more info checkout the official Docker documentation [here](https://docs.docker.com/language/java/)

----
