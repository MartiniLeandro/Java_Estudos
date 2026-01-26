package com.demo.repositories;

import com.demo.entities.Cliente;
import com.demo.entities.ENUMS.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByStatus(Status status);

    Boolean existsByEmail(String email);

    Boolean existsByStatus(Status status);

    UserDetails findByEmail(String email);
}
