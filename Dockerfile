FROM openjdk:16-jdk-alpine
MAINTAINER Aegro
COPY build/libs/productive-areas-api-1.0.0.jar productive-areas-api-1.0.0.jar
ENTRYPOINT ["java","-jar","/productive-areas-api-1.0.0.jar"]