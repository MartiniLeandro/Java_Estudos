package com.sistema_barbearia.entities.DTOS;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record BarbeiroCreateDTO(@NotNull LocalTime inicioTrabalho, @NotNull LocalTime finalTrabalho, @NotNull Long user_id) {
}
