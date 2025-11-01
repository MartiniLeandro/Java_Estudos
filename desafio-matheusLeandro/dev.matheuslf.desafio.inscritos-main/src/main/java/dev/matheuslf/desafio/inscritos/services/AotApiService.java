package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersFilterDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersResultDTO;
import org.springframework.core.ParameterizedTypeReference;
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
                    .uri(uriBuilder -> {
                        uriBuilder.path("/characters");
                        if(page != null){
                            uriBuilder.queryParam("page", page);
                        }
                        return uriBuilder.build();
                    })
                    .retrieve()
                    .bodyToMono(AotCharactersResultDTO.class)
                    .block();

        return result.results().stream().map(AotCharactersDTO::new).toList();
    }

    public AotCharactersDTO characterById(Long id){
        return webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/characters").queryParam("/id",id).build())
                    .retrieve()
                    .bodyToMono(AotCharactersDTO.class)
                    .block();
    }

    public List<AotCharactersDTO> charactersByFilters(AotCharactersFilterDTO data) {
        AotCharactersResultDTO result = webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/characters");

                    if (data.name() != null) uriBuilder.queryParam("name", data.name());
                    if (data.gender() != null) uriBuilder.queryParam("gender", data.gender());
                    if (data.status() != null) uriBuilder.queryParam("status", data.status());
                    if (data.occupation() != null) uriBuilder.queryParam("occupation", data.occupation());

                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(AotCharactersResultDTO.class)
                .block();

        if (result == null) return null;
        return result.results().stream().map(AotCharactersDTO::new).toList();
    }
}
