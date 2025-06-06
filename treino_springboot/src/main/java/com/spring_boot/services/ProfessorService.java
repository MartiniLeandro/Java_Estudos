package com.spring_boot.services;

import java.util.List;

import com.spring_boot.exceptions.UserNotFoundExcepiton;
import com.spring_boot.repository.ProfessorRepository;

import com.spring_boot.models.Professor;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

    public Professor findById(Long id){
        return professorRepository.findById(id).orElseThrow(() -> new UserNotFoundExcepiton("Não existe professor com este ID"));
    }
}
