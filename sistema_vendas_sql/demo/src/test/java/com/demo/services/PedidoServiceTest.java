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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private Cliente cliente;
    private Pedido pedido;

    @BeforeEach
    void setup() {
        cliente = new Cliente("cliente@email.com", "Cliente Teste","cliente");
        pedido = new Pedido(cliente);
    }

    // ===================== getAllPedidos =====================

    @Test
    void deveRetornarTodosPedidos() {
        when(pedidoRepository.findAll()).thenReturn(List.of(pedido));

        List<PedidoResponseDTO> result = pedidoService.getAllPedidos();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(pedidoRepository).findAll();
    }

    // ===================== getPedidoById =====================

    @Test
    void deveRetornarPedidoPorId() {
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        PedidoResponseDTO response = pedidoService.getPedidoById(1L);

        assertNotNull(response);
    }

    @Test
    void deveLancarExcecaoQuandoPedidoNaoEncontradoPorId() {
        when(pedidoRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.getPedidoById(1L)
        );

        assertEquals("Pedido não encontrado", exception.getMessage());
    }

    // ===================== getPedidosByCliente =====================

    @Test
    void deveRetornarPedidosPorCliente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(pedidoRepository.findAllByCliente(1L)).thenReturn(List.of(pedido));

        List<PedidoResponseDTO> result = pedidoService.getPedidosByCliente(1L);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExistirAoBuscarPedidos() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.getPedidosByCliente(1L)
        );

        assertEquals("Nenhum cliente encontrado", exception.getMessage());
    }

    // ===================== getPedidosByStatus =====================

    @Test
    void deveRetornarPedidosPorStatus() {
        when(pedidoRepository.existsByStatus(StatusPedido.CRIADO)).thenReturn(true);
        when(pedidoRepository.findAllByStatus(StatusPedido.CRIADO)).thenReturn(List.of(pedido));

        List<PedidoResponseDTO> result = pedidoService.getPedidosByStatus(StatusPedido.CRIADO);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoStatusNaoExistir() {
        when(pedidoRepository.existsByStatus(StatusPedido.valueOf("CRIADO"))).thenReturn(false);

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.getPedidosByStatus(StatusPedido.valueOf("CRIADO"))
        );

        assertEquals("Status não encontrado", exception.getMessage());
    }

    // ===================== getPedidosBetweenDates =====================

    @Test
    void deveRetornarPedidosEntreDatas() {
        LocalDateTime inicio = LocalDateTime.now().minusDays(5);
        LocalDateTime fim = LocalDateTime.now();

        when(pedidoRepository.findByDataBetween(inicio, fim)).thenReturn(List.of(pedido));

        List<PedidoResponseDTO> result = pedidoService.getPedidosBetweenDates(inicio, fim);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoDatasForemInvalidas() {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fim = LocalDateTime.now().minusDays(1);

        IncorrectDateException exception = assertThrows(
                IncorrectDateException.class,
                () -> pedidoService.getPedidosBetweenDates(inicio, fim)
        );

        assertEquals("Datas inválidas", exception.getMessage());
    }

    // ===================== createPedido =====================

    @Test
    void deveCriarPedidoComSucesso() {
        PedidoCreateDTO dto = new PedidoCreateDTO(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        PedidoResponseDTO response = pedidoService.createPedido(dto);

        assertNotNull(response);
        verify(pedidoRepository).save(any(Pedido.class));
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExistirAoCriarPedido() {
        PedidoCreateDTO dto = new PedidoCreateDTO(1L);

        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.createPedido(dto)
        );

        assertEquals("Cliente nao encontrado", exception.getMessage());
    }

    // ===================== updatePedido =====================

    @Test
    void deveAtualizarPedidoComSucesso() {
        PedidoUpdateDTO dto = new PedidoUpdateDTO(
                LocalDateTime.now(),
                StatusPedido.ENTREGUE,
                1L
        );

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        PedidoResponseDTO response = pedidoService.updatePedido(dto, 1L);

        assertNotNull(response);
        verify(pedidoRepository).save(pedido);
    }

    @Test
    void deveLancarExcecaoQuandoPedidoNaoExistirAoAtualizar() {
        PedidoUpdateDTO dto = new PedidoUpdateDTO(
                LocalDateTime.now(),
                StatusPedido.CRIADO,
                1L
        );

        when(pedidoRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.updatePedido(dto, 1L)
        );

        assertEquals("Pedido não encontrado", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExistirAoAtualizarPedido() {
        PedidoUpdateDTO dto = new PedidoUpdateDTO(
                LocalDateTime.now(),
                StatusPedido.CRIADO,
                1L
        );

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.updatePedido(dto, 1L)
        );

        assertEquals("Cliente não encontrado", exception.getMessage());
    }

    // ===================== deletePedido =====================

    @Test
    void deveDeletarPedidoComSucesso() {
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        pedidoService.deletePedido(1L);

        verify(pedidoRepository).delete(pedido);
    }

    @Test
    void deveLancarExcecaoQuandoPedidoNaoExistirAoDeletar() {
        when(pedidoRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> pedidoService.deletePedido(1L)
        );

        assertEquals("Pedido não existe", exception.getMessage());
    }
}
