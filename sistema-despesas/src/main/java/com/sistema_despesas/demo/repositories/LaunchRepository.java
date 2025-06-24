package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaunchRepository extends JpaRepository<Launch, Long> {
}
