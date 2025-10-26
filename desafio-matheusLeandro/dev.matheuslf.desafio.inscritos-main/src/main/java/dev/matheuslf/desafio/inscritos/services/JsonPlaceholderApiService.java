package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.JsonPlaceholderPostsDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class JsonPlaceholderApiService {

    private final WebClient webClient;

    public JsonPlaceholderApiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public List<JsonPlaceholderPostsDTO> getAllPosts(){
        return webClient.get().uri("/posts")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<JsonPlaceholderPostsDTO>>() {})
                .block();
    }

    public JsonPlaceholderPostsDTO getPostById(Long id){
        return webClient.get()
                .uri("/posts/{id}",id)
                .retrieve()
                .bodyToMono(JsonPlaceholderPostsDTO.class)
                .block();
    }


}
