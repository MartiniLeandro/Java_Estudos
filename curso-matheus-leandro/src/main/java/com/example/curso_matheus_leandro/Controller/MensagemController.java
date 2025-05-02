package com.example.curso_matheus_leandro.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso_matheus_leandro.service.MensageService;

@RestController
@RequestMapping("/api")
public class MensagemController {

    private final MensageService mensageService;

    public MensagemController(MensageService mensageService) {
        this.mensageService = mensageService;
    }

    @GetMapping("/mensagem")
    public String mensagem(){
        return mensageService.obterMensagem();
    }
}
