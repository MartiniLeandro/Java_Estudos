package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.AotCharactersFilterDTO;
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
    public ResponseEntity<List<AotCharactersDTO>> allCharacters(@RequestParam(required = false) Integer page){
        return ResponseEntity.ok().body(aotApiService.allCharacters(page));
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<AotCharactersDTO> characterById(@PathVariable Long id){
        return ResponseEntity.ok().body(aotApiService.characterById(id));
    }

    @GetMapping("/characters/filter")
    public ResponseEntity<List<AotCharactersDTO>> allCharactersByStatus(@RequestParam(required = false) String name,
                                                                        @RequestParam(required = false) String gender,
                                                                        @RequestParam(required = false) String status,
                                                                        @RequestParam(required = false) String occupation){
        AotCharactersFilterDTO aotCharactersFilterDTO = new AotCharactersFilterDTO(name, gender, status, occupation);
        return ResponseEntity.ok().body(aotApiService.charactersByFilters(aotCharactersFilterDTO));
    }
}
