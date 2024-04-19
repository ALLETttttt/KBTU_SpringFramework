FROM openjdk:alpine
VOLUME /tmp
ARG RAILS_ENV=production
ARG FOO
COPY target/SIS8_Docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]