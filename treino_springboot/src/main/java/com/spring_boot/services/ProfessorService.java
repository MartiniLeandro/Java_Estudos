package com.spring_boot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_boot.models.Professor;

@Service
public class ProfessorService {
    
    private ProfessorService professorRepository;

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id);
    }
}
