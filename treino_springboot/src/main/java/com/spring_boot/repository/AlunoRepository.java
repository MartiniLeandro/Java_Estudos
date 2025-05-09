package com.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
