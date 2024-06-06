FROM openjdk:22
WORKDIR /src
COPY target/messageBroker-0.0.1-SNAPSHOT.jar message-broker-1.jar
CMD ["java", "-jar", "message-broker-1.jar"]
