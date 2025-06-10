package com.consultaMedica.repositories;

import com.consultaMedica.entities.Medico;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    boolean existsByNome(String nome);
    boolean existsByCrm(Long crm);
    UserDetails findByNome(String nome);
}
