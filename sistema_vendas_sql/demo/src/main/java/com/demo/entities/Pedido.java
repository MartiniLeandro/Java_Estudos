package com.demo.entities;

import com.demo.entities.DTOS.PedidoCreateDTO;
import com.demo.entities.ENUMS.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @NotNull
    @Column(name = "data")
    private LocalDateTime data;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Pedido() {}
    public Pedido(Pedido pedido) {
        this.data = LocalDateTime.now();
        this.status = StatusPedido.CRIADO;
        this.cliente = pedido.getCliente();
    }
    public Pedido(PedidoCreateDTO data){
        this.data = LocalDateTime.now();
        this.status = StatusPedido.CRIADO;
        this.cliente = data.cliente();
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
