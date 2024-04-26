FROM bellsoft/liberica-openjdk-alpine-musl:21
ARG JAR_FILE=target/*.jar
COPY target/address-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]