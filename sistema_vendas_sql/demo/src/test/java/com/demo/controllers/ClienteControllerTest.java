package com.demo.controllers;

import com.demo.Controllers.ClienteController;
import com.demo.entities.Cliente;
import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
import com.demo.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@WebMvcTest(controllers = ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    private Cliente c1,c2;

    @BeforeEach
    void setup(){
        c1 = new Cliente("cliente1", "cliente1@email.com");
        c2 = new Cliente("cliente2", "cliente2@email.com");
    }

    @Test
    void testFindAllClientes() throws Exception {
        List<ClienteResponseDTO> clientes = List.of(new ClienteResponseDTO(c1),new ClienteResponseDTO(c2));
        when(clienteService.getAllClientes()).thenReturn(clientes);

        mockMvc.perform(get("/clientes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("cliente1@email.com"))
                .andExpect(jsonPath("$[1].email").value("cliente2@email.com"));

    }

    @Test
    void testFindClienteById() throws Exception {
        c1.setId(1L);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(c1);
        when(clienteService.getClienteById(anyLong())).thenReturn(clienteResponseDTO);

        mockMvc.perform(get("/clientes/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("cliente1@email.com"));
    }

    @Test
    void testFindClienteByIdNotFound() throws Exception {
        when(clienteService.getClienteById(anyLong())).thenThrow(new NotFoundException("Cliente nao encontrado"));

        mockMvc.perform(get("/clientes/{id}",1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testFindClienteByStatus() throws Exception {
        List<ClienteResponseDTO> clientesAtivos = List.of(new ClienteResponseDTO(c1),new ClienteResponseDTO(c2));
        when(clienteService.getClienteByStatus(Status.valueOf("ATIVO"))).thenReturn(clientesAtivos);

        mockMvc.perform(get("/clientes/status").param("status","ATIVO"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath(("$[0].email")).value("cliente1@email.com"))
                .andExpect(jsonPath(("$[1].email")).value("cliente2@email.com"));
    }

    @Test
    void testFindClienteByStatusFailed() throws Exception {
        when(clienteService.getClienteByStatus(any(Status.class))).thenThrow(new NotFoundException("Status nao encontrado"));

        mockMvc.perform(get("/clientes/status").param("status","ATIVO"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    void testCreateCliente() throws Exception {
        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO("cliente3","cliente3@email.com");
        Cliente cliente = new Cliente(clienteRequestDTO.nome(),clienteRequestDTO.email());
        when(clienteService.createCliente(clienteRequestDTO)).thenReturn(new ClienteResponseDTO(cliente));

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clienteRequestDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("cliente3"));
    }

    @Test
    void testCreateClienteFailed() throws Exception {
        when(clienteService.createCliente(any(ClienteRequestDTO.class))).thenThrow(new AlreadyExistsException("Email já cadastrado"));

        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateCliente() throws Exception {
        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO("cliente3","cliente3@email.com");
        c1.setId(1L);
        c1.setNome(clienteRequestDTO.nome());
        c1.setEmail(clienteRequestDTO.email());
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(c1);
        when(clienteService.updateCliente(1L,clienteRequestDTO)).thenReturn(clienteResponseDTO);

        mockMvc.perform(put("/clientes/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clienteRequestDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("cliente3"));
    }

    @Test
    void testUpdateClienteFailed() throws Exception {
        when(clienteService.updateCliente(anyLong(),any(ClienteRequestDTO.class))).thenThrow(new NotFoundException("Cliente não encontrado"));

        mockMvc.perform(put("/clientes/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(c1)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateClienteFailed2() throws Exception {
        when(clienteService.updateCliente(anyLong(),any(ClienteRequestDTO.class))).thenThrow(new AlreadyExistsException("Este email já existe"));

        mockMvc.perform(put("/clientes/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(c1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteCliente() throws Exception {
        doNothing().when(clienteService).deleteCliente(anyLong());

        mockMvc.perform(delete("/clientes/{id}",1L))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteClienteFailed() throws Exception {
        doThrow(new NotFoundException("Cliente não encontrado")).when(clienteService).deleteCliente(anyLong());

        mockMvc.perform(delete("/clientes/{id}",1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
