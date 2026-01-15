package com.demo.repositories;

import com.demo.entities.ItemPedido;
import com.demo.entities.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId> {
}
