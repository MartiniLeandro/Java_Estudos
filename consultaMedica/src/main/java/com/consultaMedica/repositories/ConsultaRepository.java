package com.consultaMedica.repositories;

import com.consultaMedica.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByData(LocalDate data);
}
