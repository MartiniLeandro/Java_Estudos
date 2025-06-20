package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO(@NotBlank String telefone,@NotNull Long user_id) {
}
