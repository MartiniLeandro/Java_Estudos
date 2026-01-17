package com.demo.entities.DTOS;

import com.demo.entities.Cliente;
import com.demo.entities.ENUMS.Status;

import java.time.LocalDateTime;

public record ClienteResponseDTO(Long id, String nome, String email, LocalDateTime dataCadastro, Status status) {
    public ClienteResponseDTO(Cliente cliente){
        this(
                cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getDataCadastro(), cliente.getStatus()
        );
    }
}
