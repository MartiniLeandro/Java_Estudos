package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.ReceitasDespesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitasDespesasRepository extends JpaRepository<ReceitasDespesas, Long> {
}
