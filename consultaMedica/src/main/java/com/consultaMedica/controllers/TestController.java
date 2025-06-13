package com.consultaMedica.controllers;

import com.consultaMedica.entities.Medico;
import com.consultaMedica.entities.Paciente;
import com.consultaMedica.services.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/medicos")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<List<Medico>> findAllMedicos(){
        List<Medico> allMedicos = testService.listAllMedicos();
        return ResponseEntity.ok().body(allMedicos);
    }

    @GetMapping("/pacientes")
    @PreAuthorize("hasRole('PACIENTE')")
    public ResponseEntity<List<Paciente>> findAllPacientes(){
        List<Paciente> allPacientes = testService.listAllPacientes();
        return ResponseEntity.ok().body(allPacientes);
    }
}
