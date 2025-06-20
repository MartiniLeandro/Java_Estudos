package com.sistema_barbearia.entities.DTOS.agendamentosCliente;

import jakarta.validation.constraints.NotNull;

public record DeleteAgendamentosDTO(@NotNull Long idCliente, @NotNull int index) {
}
