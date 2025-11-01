package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ViaCepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCepService {

    private final WebClient webClient;

    public ViaCepService(){
        this.webClient = WebClient.builder()
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public ViaCepResponseDTO getCepData(String cep){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("cep",cep).path("json").build())
                .retrieve()
                .bodyToMono(ViaCepResponseDTO.class)
                .block();

    }
}
