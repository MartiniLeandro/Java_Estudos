package com.demo.entities.DTOS;

import com.demo.entities.ENUMS.StatusPedido;
import com.demo.entities.Pedido;

import java.time.LocalDateTime;

public record PedidoResponseDTO(Long idPedido, LocalDateTime data, StatusPedido status, Long clienteId) {
    public PedidoResponseDTO(Pedido pedido){
        this(
                pedido.getIdPedido(), pedido.getData(), pedido.getStatus(), pedido.getCliente().getId()
        );
    }
}
