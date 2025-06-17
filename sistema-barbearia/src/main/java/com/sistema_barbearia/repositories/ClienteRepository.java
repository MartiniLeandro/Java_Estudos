package com.sistema_barbearia.repositories;

import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByUser(User user);
}
