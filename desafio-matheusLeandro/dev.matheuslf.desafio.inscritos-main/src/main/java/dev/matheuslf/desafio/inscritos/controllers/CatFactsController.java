package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.CatFactResponseDTO;
import dev.matheuslf.desafio.inscritos.services.CatFactsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-api/cats")
public class CatFactsController {

    private final CatFactsService catFactsService;

    public CatFactsController(CatFactsService catFactsService) {
        this.catFactsService = catFactsService;
    }

    @GetMapping
    public ResponseEntity<CatFactResponseDTO> getCatFact(){
        return ResponseEntity.ok().body(catFactsService.getCatFact());
    }
}
