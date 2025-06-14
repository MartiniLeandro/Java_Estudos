package com.sistema_barbearia.repositories;

import com.sistema_barbearia.entities.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}
