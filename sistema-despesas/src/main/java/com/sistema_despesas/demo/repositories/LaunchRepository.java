package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long> {
    List<Launch> findAllByUserId(Long id);
    List<Launch> findByUserAndDataBetween(User user, LocalDate dataInicial, LocalDate dataFinal);
}
