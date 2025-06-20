package com.sistema_barbearia.entities.DTOS.agendamentosBarbeiro;

import jakarta.validation.constraints.NotNull;

public record AddAgendamentoBarbeiroDTO(String agendamento, @NotNull Long idBarbeiro) {
}
