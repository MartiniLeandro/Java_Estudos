package com.consultaMedica.controllers;

import com.consultaMedica.entities.Paciente;
import com.consultaMedica.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> findAllPacientes(){
        List<Paciente> pacientes = pacienteService.findAll();
        return ResponseEntity.ok().body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findPacienteById(@PathVariable Long id){
        Paciente pacienteId = pacienteService.findById(id);
        return ResponseEntity.ok().body(pacienteId);
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente){
        Paciente newPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok().body(newPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente updatePaciente = pacienteService.updatePaciente(id,paciente);
        return ResponseEntity.ok().body(updatePaciente);
    }

}
