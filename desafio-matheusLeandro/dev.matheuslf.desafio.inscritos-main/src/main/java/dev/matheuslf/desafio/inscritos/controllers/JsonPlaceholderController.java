package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.JsonPlaceholderPostsDTO;
import dev.matheuslf.desafio.inscritos.services.JsonPlaceholderApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test-api/json")
public class JsonPlaceholderController {

    private final JsonPlaceholderApiService jsonPlaceholderApiService;

    public JsonPlaceholderController(JsonPlaceholderApiService jsonPlaceholderApiService) {
        this.jsonPlaceholderApiService = jsonPlaceholderApiService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<JsonPlaceholderPostsDTO>> getAllPosts(){
        return ResponseEntity.ok().body(jsonPlaceholderApiService.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<JsonPlaceholderPostsDTO> getPostById(@PathVariable Long id){
        return ResponseEntity.ok().body(jsonPlaceholderApiService.getPostById(id));
    }

    @PostMapping("/posts")
    public ResponseEntity<JsonPlaceholderPostsDTO> createPost(@RequestBody JsonPlaceholderPostsDTO data){
        return ResponseEntity.ok().body(jsonPlaceholderApiService.createPost(data));
    }
}
