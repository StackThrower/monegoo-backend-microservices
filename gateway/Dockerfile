FROM openjdk:20-slim
MAINTAINER stackthrow.com
EXPOSE 8081
COPY ../target/gateway-1.0.3.jar gateway-1.0.3.jar
ENTRYPOINT ["java","-jar","/gateway-1.0.3.jar"]