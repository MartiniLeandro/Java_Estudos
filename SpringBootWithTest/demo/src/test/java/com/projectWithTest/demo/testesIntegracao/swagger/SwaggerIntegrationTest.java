package com.projectWithTest.demo.testesIntegracao.swagger;

import com.projectWithTest.demo.config.AbstractIntegrationTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("testeIntegration")
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setupRestAssured() {
        RestAssured.port = port;
    }

    @DisplayName("Teste deve mostrar a página do Swagger")
    @Test
    void testReturnSwaggerPage() {
        String content = RestAssured.given()
                .basePath("/swagger-ui/index.html")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .asString();

        assertTrue(content.contains("Swagger UI"));
    }
}
