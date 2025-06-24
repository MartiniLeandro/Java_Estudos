package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
