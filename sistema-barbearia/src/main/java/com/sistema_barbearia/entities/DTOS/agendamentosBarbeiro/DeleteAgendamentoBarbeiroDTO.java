package com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro;

import jakarta.validation.constraints.NotNull;

public record DeleteAgendamentoBarbeiroDTO(@NotNull int index, @NotNull Long idBarbeiro) {
}
