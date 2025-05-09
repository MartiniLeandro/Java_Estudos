package com.spring_boot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring_boot.models.Aluno;
import com.spring_boot.repository.AlunoRepository;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
}
