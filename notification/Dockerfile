FROM openjdk:20-slim
MAINTAINER stackthrow.com
EXPOSE 8082
COPY ../target/notification-1.0.3.jar notification-1.0.3.jar
ENTRYPOINT ["java","-jar","/notification-1.0.3.jar"]