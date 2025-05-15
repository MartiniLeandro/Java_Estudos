package com.SistemaBilioteca_springboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaBilioteca_springboot.models.Emprestimo;
import com.SistemaBilioteca_springboot.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    
    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }
    
    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll(){
        List<Emprestimo> emprestimos = emprestimoService.findAll();
        return ResponseEntity.ok().body(emprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Long id){
        Emprestimo emprestimo = emprestimoService.findById(id);
        return ResponseEntity.ok().body(emprestimo);
    }

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody Emprestimo emprestimo){
        Emprestimo emprestimoNovo = emprestimoService.createEmprestimo(emprestimo);
        return ResponseEntity.ok().body(emprestimoNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        emprestimoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> updateById(@PathVariable Long id, Emprestimo emprestimo){
        Emprestimo emprestimoUpdate = emprestimoService.updateById(id, emprestimo);
        return ResponseEntity.ok().body(emprestimoUpdate);
    }
}
