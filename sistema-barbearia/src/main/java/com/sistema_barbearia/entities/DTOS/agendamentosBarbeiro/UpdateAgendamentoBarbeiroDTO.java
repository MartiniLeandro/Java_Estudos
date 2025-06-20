package com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro;

import jakarta.validation.constraints.NotNull;

public record UpdateAgendamentoBarbeiroDTO(@NotNull int index, String agendamento,@NotNull Long idBarbeiro) {
}
