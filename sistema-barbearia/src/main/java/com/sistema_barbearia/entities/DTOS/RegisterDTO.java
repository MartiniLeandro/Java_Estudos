package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.enums.Roles;

public record RegisterDTO(String nome, String email, String senha, Roles role) {
}
