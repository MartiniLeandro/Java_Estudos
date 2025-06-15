package com.sistema_barbearia.controllers;

import com.sistema_barbearia.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/agendamentos-cliente")
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<List<String>> verAgendamentos(){
        List<String> agendamentos = clienteService.verAgendamentos();
        return ResponseEntity.ok().body(agendamentos);
    }
}
