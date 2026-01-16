package com.demo.services;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.PedidoCreateDTO;
import com.demo.entities.DTOS.PedidoResponseDTO;
import com.demo.entities.DTOS.PedidoUpdateDTO;
import com.demo.entities.ENUMS.StatusPedido;
import com.demo.entities.Pedido;
import com.demo.repositories.ClienteRepository;
import com.demo.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<PedidoResponseDTO> getAllPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoResponseDTO::new).toList();
    }

    public PedidoResponseDTO getPedidoById(Long id){
        return new PedidoResponseDTO(pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado")));
    }

    public List<PedidoResponseDTO> getPedidosByCliente(Long idCliente){
        List<Pedido> pedidosCliente = pedidoRepository.findAllByCliente(idCliente);
        return pedidosCliente.stream().map(PedidoResponseDTO::new).toList();
    }

    public List<PedidoResponseDTO> getPedidosByStatus(StatusPedido status){
        List<Pedido> pedidosStatus = pedidoRepository.findAllByStatus(status);
        return pedidosStatus.stream().map(PedidoResponseDTO::new).toList();
    }

    public List<PedidoResponseDTO> gePedidosBetweenDates(LocalDateTime inicio, LocalDateTime fim){
        List<Pedido> pedidosBetweenDatas = pedidoRepository.findByDataBetween(inicio,fim);
        return pedidosBetweenDatas.stream().map(PedidoResponseDTO::new).toList();
    }

    public PedidoResponseDTO createPedido(PedidoCreateDTO pedido){
        Cliente cliente = clienteRepository.findById(pedido.idCliente()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido novoPedido = new Pedido(cliente);
        return new PedidoResponseDTO(pedidoRepository.save(novoPedido));
    }

    public PedidoResponseDTO updatePedido(PedidoUpdateDTO pedido, Long id){
        Pedido updatedPedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        updatedPedido.setCliente(clienteRepository.findById(pedido.idCliente()).orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
        updatedPedido.setData(pedido.data());
        updatedPedido.setStatus(pedido.status());
        pedidoRepository.save(updatedPedido);
        return new PedidoResponseDTO(updatedPedido);
    }

    public void deletePedido(Long id){
        pedidoRepository.deleteById(id);
    }


}
