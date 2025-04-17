FROM maven:3.6-openjdk-17 as builder
WORKDIR /build
COPY . .
RUN mvn install -f dto
WORKDIR /build/consumer2
RUN mvn package

FROM openjdk:17
WORKDIR /app
COPY --from=builder /build/consumer2/target/consumer2-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]