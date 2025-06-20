package com.sistema_barbearia.entities.DTOS.agendamentosCliente;

import jakarta.validation.constraints.NotNull;

public record UpdateAgendamentoDTO(@NotNull int index, String agendamento,@NotNull Long idCliente) {
}
