FROM openjdk:17
ARG JAR_FILE=target/card.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8085