FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/jboot-module-generator.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]