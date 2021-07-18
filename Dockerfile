FROM openjdk:11.0.7-slim
LABEL maintainer="me@mail.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-cuentaCorriente.jar
ENTRYPOINT ["java","-jar","/ms-cuentaCorriente.jar"]