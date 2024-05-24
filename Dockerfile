FROM openjdk:22
ADD . /src
WORKDIR /src
RUN ./mvnw clean package install -DskipTests
ENTRYPOINT ["java","-jar","target/messageBroker-0.0.1-SNAPSHOT.jar"]
