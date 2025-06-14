package com.sistema_barbearia.repositories;

import com.sistema_barbearia.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
