FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /docker/jboot-module-generator.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]