package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    Categorias findByNome(String nome);
}
