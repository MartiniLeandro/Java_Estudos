package com.onsign.challenge.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {

    @Bean
    public org.springframework.web.reactive.function.client.WebClient webClient() {
        return org.springframework.web.reactive.function.client.WebClient.builder()
                .baseUrl("https://api.onsign.tv/dev-challenge")
                .build();
    }
}
