package com.demo.repositories;

import com.demo.entities.Cliente;
import com.demo.entities.ENUMS.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByStatus(Status status);

    Cliente findByEmail(String email);
}
