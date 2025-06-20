package com.sistema_barbearia.entities.DTOS;

import jakarta.validation.constraints.NotNull;

public record BarbeiroDTO(String inicioTrabalho, String finalTrabalho, @NotNull Long user_id) {
}
