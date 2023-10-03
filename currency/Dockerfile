FROM openjdk:20-slim
MAINTAINER stackthrow.com
EXPOSE 8080
COPY target/currency-1.0.3.jar currency-1.0.3.jar
ENTRYPOINT ["java","-jar","/currency-1.0.3.jar"]