package com.demo.controllers;

import com.demo.Controllers.ProdutoController;
import com.demo.entities.DTOS.ProdutoCreateDTO;
import com.demo.entities.DTOS.ProdutoResponseDTO;
import com.demo.entities.DTOS.ProdutoUpdateDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.IncorrectPriceException;
import com.demo.exceptions.NotFoundException;
import com.demo.services.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProdutoService produtoService;

    private ProdutoResponseDTO produtoResponse;

    @BeforeEach
    void setUp() {
        produtoResponse = mock(ProdutoResponseDTO.class);
    }

    @Test
    void testGetAllProdutos() throws Exception {
        when(produtoService.findAllProdutos()).thenReturn(List.of(produtoResponse));

        mockMvc.perform(get("/produtos"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutoById() throws Exception {
        when(produtoService.findById(anyLong())).thenReturn(produtoResponse);

        mockMvc.perform(get("/produtos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutoByIdFailed() throws Exception {
        when(produtoService.findById(anyLong()))
                .thenThrow(new NotFoundException("Produto não encontrado"));

        mockMvc.perform(get("/produtos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetProdutosByCategoria() throws Exception {
        when(produtoService.findAllByIdCategoria(anyLong()))
                .thenReturn(List.of(produtoResponse));

        mockMvc.perform(get("/produtos/categoria/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutosByCategoriaFailed() throws Exception {
        when(produtoService.findAllByIdCategoria(anyLong()))
                .thenThrow(new NotFoundException("Categoria não encontrada"));

        mockMvc.perform(get("/produtos/categoria/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetProdutosByPreco() throws Exception {
        when(produtoService.findAllByPreco(anyDouble()))
                .thenReturn(List.of(produtoResponse));

        mockMvc.perform(get("/produtos/preco")
                        .param("preco", "100"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutosByPrecoFailed() throws Exception {
        when(produtoService.findAllByPreco(anyDouble()))
                .thenThrow(new IncorrectPriceException("Valor inválido"));

        mockMvc.perform(get("/produtos/preco")
                        .param("preco", "-10"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetProdutosBetweenPreco() throws Exception {
        when(produtoService.findAllBetweenPreco(anyDouble(), anyDouble()))
                .thenReturn(List.of(produtoResponse));

        mockMvc.perform(get("/produtos/precos")
                        .param("preco_min", "50")
                        .param("preco_max", "200"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutosBetweenPrecoFailed() throws Exception {
        when(produtoService.findAllBetweenPreco(anyDouble(), anyDouble()))
                .thenThrow(new IncorrectPriceException("Valores inválidos"));

        mockMvc.perform(get("/produtos/preco-between")
                        .param("min", "200")
                        .param("max", "50"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetProdutosByStatus() throws Exception {
        when(produtoService.findAllByStatus(any(Status.class)))
                .thenReturn(List.of(produtoResponse));

        mockMvc.perform(get("/produtos/status")
                        .param("status", Status.ATIVO.name()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetProdutosByStatusFailed() throws Exception {
        when(produtoService.findAllByStatus(any(Status.class)))
                .thenThrow(new NotFoundException("Status inexistente"));

        mockMvc.perform(get("/produtos/status")
                        .param("status", Status.ATIVO.name()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateProduto() throws Exception {
        ProdutoCreateDTO dto = new ProdutoCreateDTO(
                "Produto Teste",
                100.0,
                1L
        );

        when(produtoService.createProduto(any()))
                .thenReturn(produtoResponse);

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateProdutoFailed() throws Exception {
        when(produtoService.createProduto(any()))
                .thenThrow(new AlreadyExistsException("Já existe um produto com este nome"));

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mock(ProdutoCreateDTO.class))))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateProduto() throws Exception {
        ProdutoUpdateDTO dto = new ProdutoUpdateDTO(
                "Produto Atualizado",
                150.0,
                1L,
                Status.ATIVO
        );

        when(produtoService.updateProduto(any(), anyLong()))
                .thenReturn(produtoResponse);

        mockMvc.perform(put("/produtos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateProdutoFailed() throws Exception {
        when(produtoService.updateProduto(any(), anyLong()))
                .thenThrow(new NotFoundException("Produto não encontrado"));

        mockMvc.perform(put("/produtos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mock(ProdutoUpdateDTO.class))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteProduto() throws Exception {
        doNothing().when(produtoService).deleteProduto(anyLong());

        mockMvc.perform(delete("/produtos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteProdutoFailed() throws Exception {
        doThrow(new NotFoundException("Produto não encontrado"))
                .when(produtoService).deleteProduto(anyLong());

        mockMvc.perform(delete("/produtos/{id}", 1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
