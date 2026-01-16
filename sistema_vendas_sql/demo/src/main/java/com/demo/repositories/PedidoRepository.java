package com.demo.repositories;

import com.demo.entities.ENUMS.StatusPedido;
import com.demo.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select * from pedido where id_cliente = :idCliente", nativeQuery = true)
    public List<Pedido> findAllByCliente(Long idCliente);

    @Query(value = "select * from pedido where status = :status", nativeQuery = true)
    public List<Pedido> findAllByStatus(StatusPedido status);

    @Query(value = "select * from pedido where data between :inicio and :fim", nativeQuery = true)
    public List<Pedido> findAllBetweenDates(LocalDateTime inicio, LocalDateTime fim);
}
