package dev.matheuslf.desafio.inscritos.config;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class IntegrationTestConfig {

    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?>postgresContainer = new PostgreSQLContainer<>("postgres:15");

}
