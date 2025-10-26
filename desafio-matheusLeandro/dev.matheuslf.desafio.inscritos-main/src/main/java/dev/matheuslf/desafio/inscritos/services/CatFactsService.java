package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.CatFactResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CatFactsService {

    private final WebClient webClient;

    public CatFactsService(){
        this.webClient = WebClient.builder()
                .baseUrl("https://catfact.ninja")
                .build();
    }

    public CatFactResponseDTO getCatFact(){
        return webClient.get()
                .uri("/fact")
                .retrieve()
                .bodyToMono(CatFactResponseDTO.class)
                .block();
    }
}
