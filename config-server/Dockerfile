FROM openjdk:17-alpine
ARG JAR_FILE=target/config-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
