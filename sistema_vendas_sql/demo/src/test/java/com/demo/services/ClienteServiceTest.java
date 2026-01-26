package com.demo.services;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
import com.demo.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente c1;
    private Cliente c2;

    @BeforeEach
    void setup() {
        c1 = new Cliente("test1@email.com", "Test 1");
        c2 = new Cliente("test2@email.com", "Test 2");
    }

    // ===================== getAllClientes =====================

    @Test
    void deveRetornarTodosClientes() {
        when(clienteRepository.findAll()).thenReturn(List.of(c1, c2));

        List<ClienteResponseDTO> result = clienteService.getAllClientes();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(clienteRepository).findAll();
    }

    // ===================== getClienteById =====================

    @Test
    void deveRetornarClientePorId() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(c1));

        ClienteResponseDTO response = clienteService.getClienteById(1L);

        assertNotNull(response);
        assertEquals(c1.getEmail(), response.email());
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoEncontradoPorId() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> clienteService.getClienteById(1L)
        );

        assertEquals("Cliente nao encontrado", exception.getMessage());
    }

    // ===================== getClienteByStatus =====================

    @Test
    void deveRetornarClientesPorStatus() {
        when(clienteRepository.existsByStatus(Status.ATIVO)).thenReturn(true);
        when(clienteRepository.findAllByStatus(Status.ATIVO)).thenReturn(List.of(c1));

        List<ClienteResponseDTO> result = clienteService.getClienteByStatus(Status.ATIVO);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoStatusNaoExistir() {
        when(clienteRepository.existsByStatus(Status.DESATIVADO)).thenReturn(false);

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> clienteService.getClienteByStatus(Status.DESATIVADO)
        );

        assertEquals("Status não encontrado", exception.getMessage());
    }

    // ===================== createCliente =====================

    @Test
    void deveCriarClienteComSucesso() {
        ClienteRequestDTO dto = new ClienteRequestDTO("novo@email.com", "Novo");

        when(clienteRepository.existsByEmail(dto.email())).thenReturn(false);

        ClienteResponseDTO response = clienteService.createCliente(dto);

        assertNotNull(response);
        verify(clienteRepository).save(any(Cliente.class));
    }

    @Test
    void deveLancarExcecaoQuandoEmailJaExistirAoCriar() {
        ClienteRequestDTO dto = new ClienteRequestDTO(c1.getEmail(), "Nome");

        when(clienteRepository.existsByEmail(dto.email())).thenReturn(true);

        AlreadyExistsException exception = assertThrows(
                AlreadyExistsException.class,
                () -> clienteService.createCliente(dto)
        );

        assertEquals("Email já cadastrado", exception.getMessage());
    }

    // ===================== updateCliente =====================

    @Test
    void deveAtualizarClienteComSucesso() {
        ClienteRequestDTO dto = new ClienteRequestDTO("Novo Nome","novo@email.com");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(clienteRepository.existsByEmail(dto.email())).thenReturn(false);

        ClienteResponseDTO response = clienteService.updateCliente(1L, dto);

        assertEquals("novo@email.com", response.email());
        verify(clienteRepository).save(c1);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExistirAoAtualizar() {
        ClienteRequestDTO dto = new ClienteRequestDTO("email@email.com", "Nome");

        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> clienteService.updateCliente(1L, dto)
        );

        assertEquals("Cliente nao encontrado", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoEmailJaExistirAoAtualizar() {
        ClienteRequestDTO dto = new ClienteRequestDTO("existente@email.com", "Nome");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(clienteRepository.existsByEmail(dto.email())).thenReturn(true);

        AlreadyExistsException exception = assertThrows(
                AlreadyExistsException.class,
                () -> clienteService.updateCliente(1L, dto)
        );

        assertEquals("Este email já existe", exception.getMessage());
    }

    // ===================== deleteCliente =====================

    @Test
    void deveDeletarClienteComSucesso() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(c1));

        clienteService.deleteCliente(1L);

        verify(clienteRepository).delete(c1);
    }

    @Test
    void deveLancarExcecaoQuandoClienteNaoExistirAoDeletar() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> clienteService.deleteCliente(1L)
        );

        assertEquals("Cliente nao encontrado", exception.getMessage());
    }
}
