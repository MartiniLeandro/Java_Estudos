package com.spring_boot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.models.Aluno;
import com.spring_boot.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }



    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return ResponseEntity.ok().body(alunos);
    }
}
