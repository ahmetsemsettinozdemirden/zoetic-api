FROM maven:3.6.3-jdk-8-slim

WORKDIR /usr/local/app

COPY ./pom.xml ./

RUN mvn dependency:go-offline -B
