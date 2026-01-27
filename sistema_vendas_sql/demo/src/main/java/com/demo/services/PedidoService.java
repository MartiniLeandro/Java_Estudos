package com.demo.services;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.PedidoCreateDTO;
import com.demo.entities.DTOS.PedidoResponseDTO;
import com.demo.entities.DTOS.PedidoUpdateDTO;
import com.demo.entities.ENUMS.StatusPedido;
import com.demo.entities.Pedido;
import com.demo.exceptions.IncorrectDateException;
import com.demo.exceptions.NotFoundException;
import com.demo.repositories.ClienteRepository;
import com.demo.repositories.PedidoRepository;
import com.demo.security.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final TokenService tokenService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, TokenService tokenService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.tokenService = tokenService;
    }

    public List<PedidoResponseDTO> getAllPedidos(String token){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoResponseDTO::new).toList();
    }

    public PedidoResponseDTO getPedidoById(Long id){
        return new PedidoResponseDTO(pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado")));
    }

    public List<PedidoResponseDTO> getPedidosByCliente(Long idCliente){
        if(clienteRepository.findById(idCliente).isEmpty()) throw new NotFoundException("Nenhum cliente encontrado");
        List<Pedido> pedidosCliente = pedidoRepository.findAllByCliente(idCliente);
        return pedidosCliente.stream().map(PedidoResponseDTO::new).toList();
    }

    public List<PedidoResponseDTO> getPedidosByStatus(StatusPedido status){
        if(!pedidoRepository.existsByStatus(status)) throw new NotFoundException("Status não encontrado");
        List<Pedido> pedidosStatus = pedidoRepository.findAllByStatus(status);
        return pedidosStatus.stream().map(PedidoResponseDTO::new).toList();
    }

    public List<PedidoResponseDTO> getPedidosBetweenDates(LocalDateTime inicio, LocalDateTime fim){
        if(inicio.isAfter(fim) || fim.isBefore(inicio)) throw new IncorrectDateException("Datas inválidas");
        List<Pedido> pedidosBetweenDatas = pedidoRepository.findByDataBetween(inicio,fim);
        return pedidosBetweenDatas.stream().map(PedidoResponseDTO::new).toList();
    }

    public PedidoResponseDTO createPedido(PedidoCreateDTO pedido){
        Cliente cliente = clienteRepository.findById(pedido.idCliente()).orElseThrow(() -> new NotFoundException("Cliente nao encontrado"));
        Pedido novoPedido = new Pedido(cliente);
        return new PedidoResponseDTO(pedidoRepository.save(novoPedido));
    }

    public PedidoResponseDTO updatePedido(PedidoUpdateDTO pedido, Long id){
        Pedido updatedPedido = pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
        updatedPedido.setCliente(clienteRepository.findById(pedido.idCliente()).orElseThrow(() -> new NotFoundException("Cliente não encontrado")));
        updatedPedido.setData(pedido.data());
        updatedPedido.setStatus(pedido.status());
        pedidoRepository.save(updatedPedido);
        return new PedidoResponseDTO(updatedPedido);
    }

    public void deletePedido(Long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido não existe"));
        pedidoRepository.delete(pedido);
    }


    public Cliente getClienteByToken(String token){
        String email = tokenService.validateToken(token);
        return clienteRepository.findClienteByEmail(email);
    }

}
