FROM maven:3.8.6-jdk-20 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:20
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar

ENTRYPOINT java -jar application.jar