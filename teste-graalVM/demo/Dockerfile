# ==========================================
# BUILD NATIVO
# ==========================================
FROM container-registry.oracle.com/graalvm/native-image:25-ol9 AS builder

WORKDIR /workspace

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN sed -i 's/\r$//' mvnw && chmod +x mvnw

RUN ./mvnw clean -Pnative native:compile -DskipTests


# ==========================================
# RUNTIME
# ==========================================
FROM oraclelinux:9-slim

WORKDIR /app

COPY --from=builder /workspace/target/demo /app/demo

RUN chmod +x /app/demo

EXPOSE 8080

ENTRYPOINT ["/app/demo"]