package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class AotApiService {

    private final WebClient webClient;

    public AotApiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.attackontitanapi.com")
                .build();
    }

    public List<AotCharactersDTO> allCharacters(Integer page){
        AotCharactersResultDTO result = webClient.get()
                    .uri("/characters?page={page}",page)
                    .retrieve()
                    .bodyToMono(AotCharactersResultDTO.class)
                    .block();

        if(result == null) return null;
        return result.results().stream().map(AotCharactersDTO::new).toList();
    }

    public AotCharactersDTO characterById(Long id){
        return webClient.get()
                    .uri("/characters/{id}",id)
                    .retrieve()
                    .bodyToMono(AotCharactersDTO.class)
                    .block();
    }

    public List<AotCharactersDTO> charactersByStatus(String status){
        AotCharactersResultDTO result = webClient.get()
                .uri("/characters?status={status}",status)
                .retrieve()
                .bodyToMono(AotCharactersResultDTO.class)
                .block();

        if(result == null) return null;
        return result.results().stream().map(AotCharactersDTO::new).toList();
    }
}
