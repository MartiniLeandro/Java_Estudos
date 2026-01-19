package com.demo.repositories;

import com.demo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);

    Boolean existsByNome(String nome);
}
