FROM openjdk:alpine
VOLUME /tmp
COPY target/SIS8_Docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]