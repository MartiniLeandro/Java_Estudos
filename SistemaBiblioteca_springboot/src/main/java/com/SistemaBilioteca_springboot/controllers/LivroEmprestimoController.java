package com.SistemaBilioteca_springboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaBilioteca_springboot.models.LivroEmprestimo;
import com.SistemaBilioteca_springboot.services.LivroEmprestimoService;

@RestController
@RequestMapping("/livros_emprestimo")
public class LivroEmprestimoController {
    
    private LivroEmprestimoService livroEmprestimoService;

    public LivroEmprestimoController(LivroEmprestimoService livroEmprestimoService) {
        this.livroEmprestimoService = livroEmprestimoService;
    }
    
    @GetMapping
    public ResponseEntity<List<LivroEmprestimo>> findAll(){
        List<LivroEmprestimo> livrosEmprestimos = livroEmprestimoService.findAll();
        return ResponseEntity.ok().body(livrosEmprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroEmprestimo> findById(@PathVariable Long id){
        LivroEmprestimo livroEmprestimo = livroEmprestimoService.findById(id);
        return ResponseEntity.ok().body(livroEmprestimo);
    }

    @PostMapping
    public ResponseEntity<LivroEmprestimo> createLivroEmprestimo(@RequestBody LivroEmprestimo livroEmprestimo){
        LivroEmprestimo livroEmprestimoNovo = livroEmprestimoService.createLivroEmprestimo(livroEmprestimo);
        return ResponseEntity.ok().body(livroEmprestimoNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        livroEmprestimoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
