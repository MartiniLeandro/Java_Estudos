package com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro;

import com.sistema_barbearia.entities.utils.AgendamentoBarbeiro;
import jakarta.validation.constraints.NotNull;

public record UpdateAgendamentoBarbeiroDTO(@NotNull int index, AgendamentoBarbeiro agendamento, @NotNull Long idBarbeiro) {
}
