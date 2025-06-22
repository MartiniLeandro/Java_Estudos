package com.sistema_barbearia.entities.DTOS.agendamentosCliente;

import com.sistema_barbearia.entities.utils.AgendamentoCliente;
import jakarta.validation.constraints.NotNull;

public record UpdateAgendamentoDTO(@NotNull int index, AgendamentoCliente agendamento, @NotNull Long idCliente) {
}
