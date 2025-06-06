package com.SistemaBilioteca_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SistemaBilioteca_springboot.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
