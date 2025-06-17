package com.sistema_barbearia.repositories;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    Barbeiro findByUser(User user);
}
