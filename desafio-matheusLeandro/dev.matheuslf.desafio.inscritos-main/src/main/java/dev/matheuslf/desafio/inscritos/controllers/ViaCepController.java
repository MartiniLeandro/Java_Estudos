package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ViaCepResponseDTO;
import dev.matheuslf.desafio.inscritos.services.ViaCepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test-api/cep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponseDTO> getCepData(@PathVariable String cep){
        return ResponseEntity.ok().body(viaCepService.getCepData(cep));
    }
}
