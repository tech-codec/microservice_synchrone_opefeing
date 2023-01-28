# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /opt/app

COPY .mvn .mvn
RUN apt-get update && apt-get install -y dos2unix
COPY mvnw .
COPY pom.xml .
RUN dos2unix mvnw && apt-get --purge remove -y dos2unix && rm -rf /var/lib/apt/lists/*
COPY src src
RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests



FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8084
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]
