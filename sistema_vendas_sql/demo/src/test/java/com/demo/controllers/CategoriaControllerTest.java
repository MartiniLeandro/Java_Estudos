package com.demo.controllers;

import com.demo.Controllers.CategoriaController;
import com.demo.entities.Categoria;
import com.demo.entities.DTOS.CategoriaRequestDTO;
import com.demo.entities.DTOS.CategoriaResponseDTO;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
import com.demo.services.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CategoriaService categoriaService;

    private Categoria c1,c2;

    @BeforeEach
    void setUp() {
        c1 = new Categoria("categoria1");
        c2 = new Categoria("categoria2");
    }

    @Test
    void testGetAllCategories() throws Exception {
        when(categoriaService.findAllCategorias()).thenReturn(List.of(new CategoriaResponseDTO(c1),new CategoriaResponseDTO(c2)));

        mockMvc.perform(get("/categorias"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("categoria1"))
                .andExpect(jsonPath("$[1].nome").value("categoria2"));
    }

    @Test
    void testGetCategoriaById() throws Exception {
        c1.setIdCategoria(1L);
        when(categoriaService.findById(anyLong())).thenReturn(new CategoriaResponseDTO(c1));

        mockMvc.perform(get("/categorias/{id}",c1.getIdCategoria()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("categoria1"));
    }

    @Test
    void testGetCategoriaByIdFailed() throws Exception {
        when(categoriaService.findById(anyLong())).thenThrow(new NotFoundException("Não existe esta categoria"));

        mockMvc.perform(get("/categorias/{id}",1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetByNome() throws Exception {
        when(categoriaService.findByNome(anyString())).thenReturn(new CategoriaResponseDTO(c1));

        mockMvc.perform(get("/categorias/nome").param("nome","categoria1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("categoria1"));
    }

    @Test
    void testGetByNomeFailed() throws Exception {
        when(categoriaService.findByNome(anyString())).thenThrow(new NotFoundException("Não existe esta categoria"));

        mockMvc.perform(get("/categorias/nome").param("nome","categoria1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateCategoria() throws Exception {
        Categoria categoria = new Categoria("categoria3");
        when(categoriaService.createCategoria(any(CategoriaRequestDTO.class))).thenReturn(new CategoriaResponseDTO(categoria));

        mockMvc.perform(post("/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CategoriaRequestDTO("categoria3"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("categoria3"));
    }

    @Test
    void testCreateCategoriaFailed() throws Exception {
        when(categoriaService.createCategoria(any(CategoriaRequestDTO.class))).thenThrow(new AlreadyExistsException("Já existe categoria com este nome"));

        mockMvc.perform(post("/categorias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CategoriaRequestDTO("categoria3"))))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdateCategoria() throws Exception {
        c1.setIdCategoria(1L);
        c1.setNome("nova categoria1");
        when(categoriaService.updateCategoria(anyLong(),any(CategoriaRequestDTO.class))).thenReturn(new CategoriaResponseDTO(c1));

        mockMvc.perform(put("/categorias/{id}",c1.getIdCategoria())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CategoriaRequestDTO("categoria1"))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("nova categoria1"));
    }

    @Test
    void testUpdateCategoriaFailed() throws Exception {
        c1.setIdCategoria(1L);
        when(categoriaService.updateCategoria(anyLong(),any(CategoriaRequestDTO.class))).thenThrow(new AlreadyExistsException("Já existe categoria com este nome"));

        mockMvc.perform(put("/categorias/{id}",c1.getIdCategoria())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new CategoriaRequestDTO("categoria3"))))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDeleteCategoria() throws Exception {
        c1.setIdCategoria(1L);
        doNothing().when(categoriaService).deleteCategoria(anyLong());

        mockMvc.perform(delete("/categorias/{id}",c1.getIdCategoria()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteCategoriaFailed() throws Exception {
        doThrow(new NotFoundException("Esta categoria não existe")).when(categoriaService).deleteCategoria(anyLong());

        mockMvc.perform(delete("/categorias/{id}",1L))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
