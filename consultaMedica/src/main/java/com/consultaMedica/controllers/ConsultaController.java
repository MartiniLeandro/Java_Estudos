package com.consultaMedica.controllers;

import com.consultaMedica.entities.Consulta;
import com.consultaMedica.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findConsultaById(@PathVariable Long id){
        Consulta consultaId = consultaService.findById(id);
        return ResponseEntity.ok().body(consultaId);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> findAllConsultas(){
        List<Consulta> consultas = consultaService.findAll();
        return ResponseEntity.ok().body(consultas);
    }

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta){
        Consulta createConsulta = consultaService.createConsulta(consulta);
        return ResponseEntity.ok().body(createConsulta);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultaById(@PathVariable Long id){
        consultaService.deleteConsulta(id);
    }

    @PutMapping
    public ResponseEntity<Consulta> updateConsulta(@PathVariable Long id, @RequestBody Consulta consulta){
        Consulta consultaUpdate = consultaService.updateConsulta(id,consulta);
        return ResponseEntity.ok().body(consultaUpdate);
    }
}
