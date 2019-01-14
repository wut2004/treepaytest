FROM openjdk:8-jdk-alpine
MAINTAINER Wuttichai Srisuk <tomwuts@gmail.com>
EXPOSE 8080
ADD target/testtreepay-1.0.jar treepaytest.jar
ENTRYPOINT ["java", "-jar", "/treepaytest.jar"]
