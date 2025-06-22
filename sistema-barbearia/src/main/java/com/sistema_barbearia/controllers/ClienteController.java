package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.DTOS.agendamentosCliente.AgendamentoDTO;
import com.sistema_barbearia.entities.utils.AgendamentoCliente;
import com.sistema_barbearia.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/agendamentos")
    public ResponseEntity<List<AgendamentoCliente>> verAgendamentos(@RequestHeader("Authorization") String authHeader){
        String token = authHeader.replace("Bearer ", "");
        List<AgendamentoCliente> agendamentos = clienteService.verAgendamentos(token);
        return ResponseEntity.ok().body(agendamentos);
    }

    @PostMapping("/createAgendamentos")
    public ResponseEntity<List<AgendamentoCliente>> createAgendamentos(@RequestHeader("Authorization") String authHeader, @RequestBody AgendamentoDTO data){
        String token = authHeader.replace("Bearer ", "");
        List<AgendamentoCliente> newAgendamentos = clienteService.createAgendamento(token, data);
        return ResponseEntity.ok().body(newAgendamentos);
    }
}
