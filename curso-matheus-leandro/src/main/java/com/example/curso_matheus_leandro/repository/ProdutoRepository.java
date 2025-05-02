package com.example.curso_matheus_leandro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curso_matheus_leandro.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {


    
}
