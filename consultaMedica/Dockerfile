FROM eclipse-temurin:17.0.20_8-jdk-ubi10-minimal AS build

WORKDIR /build

COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17.0.20_8-jre

WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]