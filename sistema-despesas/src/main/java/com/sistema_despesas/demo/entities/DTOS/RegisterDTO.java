package com.sistema_despesas.demo.entities.DTOS;

import com.sistema_despesas.demo.entities.utils.Roles;

public record RegisterDTO(String email, String password, Roles role) {
}
