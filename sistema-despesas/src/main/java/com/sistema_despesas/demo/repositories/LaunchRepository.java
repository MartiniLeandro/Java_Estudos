package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long> {
    List<Launch> findAllByUserId(Long id);
}
