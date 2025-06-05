package com.consultaMedica.controllers;

import com.consultaMedica.entities.Medico;
import com.consultaMedica.exceptions.UserNotFoundException;
import com.consultaMedica.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> findAllMedicos(){
        List<Medico> medicos = medicoService.findAll();
        return ResponseEntity.ok().body(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMedicoById(@PathVariable Long id){
        try{
        Medico medicoId = medicoService.findById(id);
        return ResponseEntity.ok().body(medicoId);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody @Valid Medico medico){
        Medico newMedico = medicoService.createMedico(medico);
        return ResponseEntity.ok().body(newMedico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedico(@PathVariable Long id){
        medicoService.deleteMedico(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long id, @RequestBody @Valid Medico medico){
        Medico updateMedico = medicoService.updateMedico(id,medico);
        return ResponseEntity.ok().body(updateMedico);
    }

}
