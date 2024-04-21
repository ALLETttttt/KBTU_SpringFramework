FROM bellsoft/liberica-openjdk-alpine-musl:21
VOLUME /tmp
ARG RAILS_ENV=production
ARG FOO
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
