package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersDTO;
import dev.matheuslf.desafio.inscritos.services.AotApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test-api/aot")
public class AotApiController {

    private final AotApiService aotApiService;

    public AotApiController(AotApiService aotApiService) {
        this.aotApiService = aotApiService;
    }

    @GetMapping("/characters")
    public ResponseEntity<List<AotCharactersDTO>> allCharacters(@RequestParam Integer page){
        return ResponseEntity.ok().body(aotApiService.allCharacters(page));
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<AotCharactersDTO> characterById(@PathVariable Long id){
        return ResponseEntity.ok().body(aotApiService.characterById(id));
    }

    @GetMapping("/characters/filter")
    public ResponseEntity<List<AotCharactersDTO>> allCharactersByStatus(@RequestParam String status){
        return ResponseEntity.ok().body(aotApiService.charactersByStatus(status));
    }
}
