package com.onsign.challenge.demo.services;

import com.onsign.challenge.demo.models.SocialData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ApiClientService {

    private final WebClient webClient;

    @Value("${api.token}")
    private String token;

    public ApiClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public SocialData getSocialData(){
        return webClient.get().uri("/?access_token=" +  token)
                .retrieve()
                .bodyToMono(SocialData.class)
                .block();
    }

}
