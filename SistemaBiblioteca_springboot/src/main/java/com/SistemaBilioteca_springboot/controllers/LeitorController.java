package com.SistemaBilioteca_springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaBilioteca_springboot.models.Leitor;
import com.SistemaBilioteca_springboot.services.LeitorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/leitores")
public class LeitorController {
    
    @Autowired
    private LeitorService leitorService;

    public LeitorController(LeitorService leitorService) {
        this.leitorService = leitorService;
    }
    
    @GetMapping
    public ResponseEntity<List<Leitor>> findAll(){
        List<Leitor> leitores = leitorService.findAll();
        return ResponseEntity.ok().body(leitores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leitor> findById(@PathVariable Long id){
        Leitor leitor = leitorService.findById(id);
        return ResponseEntity.ok().body(leitor);
    }

    @PostMapping
    public ResponseEntity<Leitor> createLeitor(@Valid @RequestBody Leitor leitor){
        Leitor leitorNovo = leitorService.createLeitor(leitor);
        return ResponseEntity.ok().body(leitorNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        leitorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leitor> updateById(@PathVariable Long id, @Valid @RequestBody Leitor leitor){
        Leitor leitorUpdate = leitorService.updateById(id, leitor);
        return ResponseEntity.ok().body(leitorUpdate);
    }
}
