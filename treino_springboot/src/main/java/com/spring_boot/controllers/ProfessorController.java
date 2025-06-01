package com.spring_boot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.models.Professor;
import com.spring_boot.services.ProfessorService;

@RestController
@RequestMapping (value = "/professores")
public class ProfessorController {
    
    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService; 
    }


    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        List<Professor> professores = professorService.findAll();
        return ResponseEntity.ok().body(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(Long id){
        Professor professor = professorService.findById(id);
        return ResponseEntity.ok().body(professor);
    }

}
