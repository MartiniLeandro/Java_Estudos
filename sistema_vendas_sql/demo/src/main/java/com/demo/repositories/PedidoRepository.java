package com.demo.repositories;

import com.demo.entities.ENUMS.StatusPedido;
import com.demo.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "select * from pedido where id_cliente = :idCliente", nativeQuery = true)
    public List<Pedido> findAllByCliente(Long idCliente);

    public List<Pedido> findAllByStatus(StatusPedido status);

    public List<Pedido> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
