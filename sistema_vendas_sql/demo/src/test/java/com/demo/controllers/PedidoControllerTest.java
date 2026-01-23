package com.demo.controllers;

import com.demo.Controllers.PedidoController;
import com.demo.entities.DTOS.PedidoCreateDTO;
import com.demo.entities.DTOS.PedidoResponseDTO;
import com.demo.entities.DTOS.PedidoUpdateDTO;
import com.demo.entities.ENUMS.StatusPedido;
import com.demo.exceptions.IncorrectDateException;
import com.demo.exceptions.NotFoundException;
import com.demo.services.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PedidoService pedidoService;

    private PedidoResponseDTO pedidoResponse;

    @BeforeEach
    void setUp() {
        pedidoResponse = mock(PedidoResponseDTO.class);
    }

    @Test
    void testGetAllPedidos() throws Exception {
        when(pedidoService.getAllPedidos()).thenReturn(List.of(pedidoResponse));

        mockMvc.perform(get("/pedidos"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetPedidoById() throws Exception {
        when(pedidoService.getPedidoById(anyLong())).thenReturn(pedidoResponse);

        mockMvc.perform(get("/pedidos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetPedidoByIdFailed() throws Exception {
        when(pedidoService.getPedidoById(anyLong()))
                .thenThrow(new NotFoundException("Pedido não encontrado"));

        mockMvc.perform(get("/pedidos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPedidosByCliente() throws Exception {
        when(pedidoService.getPedidosByCliente(anyLong()))
                .thenReturn(List.of(pedidoResponse));

        mockMvc.perform(get("/pedidos/cliente/{clienteId}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetPedidosByClienteFailed() throws Exception {
        when(pedidoService.getPedidosByCliente(anyLong()))
                .thenThrow(new NotFoundException("Nenhum cliente encontrado"));

        mockMvc.perform(get("/pedidos/cliente/{clienteId}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPedidosByStatus() throws Exception {
        when(pedidoService.getPedidosByStatus(any(StatusPedido.class)))
                .thenReturn(List.of(pedidoResponse));

        mockMvc.perform(get("/pedidos/status")
                        .param("status", StatusPedido.CRIADO.name()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetPedidosByStatusFailed() throws Exception {
        when(pedidoService.getPedidosByStatus(any(StatusPedido.class)))
                .thenThrow(new NotFoundException("Status não encontrado"));

        mockMvc.perform(get("/pedidos/status")
                        .param("status", StatusPedido.CRIADO.name()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetPedidosBetweenDates() throws Exception {
        when(pedidoService.getPedidosBetweenDates(any(), any()))
                .thenReturn(List.of(pedidoResponse));

        mockMvc.perform(get("/pedidos/dates")
                        .param("start", "2024-01-01T10:00:00")
                        .param("end", "2024-01-10T10:00:00"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetPedidosBetweenDatesFailed() throws Exception {
        when(pedidoService.getPedidosBetweenDates(any(), any()))
                .thenThrow(new IncorrectDateException("Datas inválidas"));

        mockMvc.perform(get("/pedidos/dates")
                        .param("start", "2024-01-10T10:00:00")
                        .param("end", "2024-01-01T10:00:00"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreatePedido() throws Exception {
        PedidoCreateDTO dto = new PedidoCreateDTO(1L);

        when(pedidoService.createPedido(any(PedidoCreateDTO.class)))
                .thenReturn(pedidoResponse);

        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreatePedidoFailed() throws Exception {
        when(pedidoService.createPedido(any(PedidoCreateDTO.class)))
                .thenThrow(new NotFoundException("Cliente nao encontrado"));

        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PedidoCreateDTO(1L))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdatePedido() throws Exception {
        PedidoUpdateDTO dto = new PedidoUpdateDTO(
                LocalDateTime.now(),
                StatusPedido.CRIADO,
                1L
                );

        when(pedidoService.updatePedido(any(PedidoUpdateDTO.class), anyLong()))
                .thenReturn(pedidoResponse);

        mockMvc.perform(put("/pedidos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdatePedidoFailed() throws Exception {
        when(pedidoService.updatePedido(any(), anyLong()))
                .thenThrow(new NotFoundException("Pedido não encontrado"));

        mockMvc.perform(put("/pedidos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mock(PedidoUpdateDTO.class))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeletePedido() throws Exception {
        doNothing().when(pedidoService).deletePedido(anyLong());

        mockMvc.perform(delete("/pedidos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeletePedidoFailed() throws Exception {
        doThrow(new NotFoundException("Pedido não existe"))
                .when(pedidoService).deletePedido(anyLong());

        mockMvc.perform(delete("/pedidos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
