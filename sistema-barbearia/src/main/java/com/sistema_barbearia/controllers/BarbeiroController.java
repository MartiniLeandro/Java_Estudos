package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.utils.AgendamentoBarbeiro;
import com.sistema_barbearia.services.BarbeiroService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    public BarbeiroController(BarbeiroService barbeiroService) {
        this.barbeiroService = barbeiroService;
    }

    @GetMapping("/agendamentos")
    public ResponseEntity<List<AgendamentoBarbeiro>> verAgendamentos(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        List<AgendamentoBarbeiro> agendamentos = barbeiroService.verAgendamentos(token);
        return ResponseEntity.ok().body(agendamentos);
    }

}
