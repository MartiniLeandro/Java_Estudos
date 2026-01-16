package com.demo.entities.DTOS;

import com.demo.entities.Cliente;
import com.demo.entities.ENUMS.StatusPedido;

import java.time.LocalDateTime;

public record PedidoUpdateDTO(LocalDateTime data, StatusPedido status, Long idCliente) {
}
