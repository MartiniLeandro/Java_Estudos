package com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro;

import com.sistema_barbearia.entities.utils.AgendamentoBarbeiro;
import jakarta.validation.constraints.NotNull;

public record AddAgendamentoBarbeiroDTO(AgendamentoBarbeiro agendamento, @NotNull Long idBarbeiro) {
}
