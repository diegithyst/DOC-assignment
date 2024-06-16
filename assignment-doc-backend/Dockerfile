FROM alpine:3.19
RUN apk update
RUN apk add --no-cache openjdk19-jre

EXPOSE 8080

ADD /target/*.jar assignment-doc-backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/assignment-doc-backend-0.0.1-SNAPSHOT.jar"]