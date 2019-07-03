FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD jboot-module-generator.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]