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

import com.SistemaBilioteca_springboot.models.Livro;
import com.SistemaBilioteca_springboot.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        List<Livro> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@Valid @RequestBody Livro livro){
        Livro livroNovo = livroService.createLivro(livro);
        return ResponseEntity.ok().body(livroNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateById(@PathVariable Long id, @Valid  @RequestBody Livro livro){
        Livro livroUpdate = livroService.updateById(id, livro);
        return ResponseEntity.ok().body(livroUpdate);
    }
}
