package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.enums.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(@NotBlank String nome, @Email @NotBlank String email,@NotBlank String senha,@NotNull Roles role) {
}
