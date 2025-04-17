FROM maven:3.6-openjdk-17 as builder
WORKDIR /build
COPY . .
RUN mvn install -f dto
WORKDIR /build/consumer1
RUN mvn package

FROM openjdk:17
WORKDIR /app
COPY --from=builder /build/consumer1/target/consumer1-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]