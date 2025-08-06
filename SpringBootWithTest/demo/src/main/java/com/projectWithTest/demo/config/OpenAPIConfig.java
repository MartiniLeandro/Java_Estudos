package com.projectWithTest.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API para testar o Swagger")
                        .version("1.0.0")
                        .description("utilizando pela primeira vez o swagger")
                        .termsOfService("")
                        .license(new License()
                                .name("Licença teste")
                                .url("https://meusite.com/licenca-de-teste")));
    }
}
