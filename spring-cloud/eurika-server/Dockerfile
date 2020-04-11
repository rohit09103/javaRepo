FROM openjdk:8-jdk-alpine
MAINTAINER rohit09103
RUN addgroup -S rohit09103 && adduser -S rohit09103 -G rohit09103
USER rohit09103:rohit09103

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8761