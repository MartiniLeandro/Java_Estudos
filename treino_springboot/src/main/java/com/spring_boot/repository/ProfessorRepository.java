package com.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
