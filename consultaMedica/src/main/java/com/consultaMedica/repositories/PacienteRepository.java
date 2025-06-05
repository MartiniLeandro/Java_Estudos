package com.consultaMedica.repositories;

import com.consultaMedica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByNome(String nome);
    boolean existsByCpf(Long cpf);
    boolean existsByTelefone(String telefone);
}
