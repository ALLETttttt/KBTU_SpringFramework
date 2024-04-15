FROM openjdk:alpine
VOLUME /tmp
COPY run.sh .
COPY target/SIS8_Docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["run.sh"]