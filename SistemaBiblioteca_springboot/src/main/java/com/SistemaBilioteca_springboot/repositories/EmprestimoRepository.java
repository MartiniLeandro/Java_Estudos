package com.SistemaBilioteca_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaBilioteca_springboot.models.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

    
}