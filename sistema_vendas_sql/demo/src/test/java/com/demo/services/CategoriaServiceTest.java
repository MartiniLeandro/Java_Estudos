package com.demo.services;

import com.demo.entities.Categoria;
import com.demo.entities.DTOS.CategoriaRequestDTO;
import com.demo.entities.DTOS.CategoriaResponseDTO;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
import com.demo.repositories.CategoriaRepository;
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
class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria c1;
    private Categoria c2;

    @BeforeEach
    void setup() {
        c1 = new Categoria("Eletrônicos");
        c2 = new Categoria("Livros");
    }

    // ===================== findAllCategorias =====================

    @Test
    void deveRetornarTodasCategorias() {
        when(categoriaRepository.findAll()).thenReturn(List.of(c1, c2));

        List<CategoriaResponseDTO> result = categoriaService.findAllCategorias();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(categoriaRepository).findAll();
    }

    // ===================== findById =====================

    @Test
    void deveRetornarCategoriaPorId() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(c1));

        CategoriaResponseDTO response = categoriaService.findById(1L);

        assertNotNull(response);
        assertEquals(c1.getNome(), response.nome());
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoEncontradaPorId() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> categoriaService.findById(1L)
        );

        assertEquals("Categoria não encontrada", exception.getMessage());
    }

    // ===================== findByNome =====================

    @Test
    void deveRetornarCategoriaPorNome() {
        when(categoriaRepository.existsByNome("Eletrônicos")).thenReturn(true);
        when(categoriaRepository.findByNome("Eletrônicos")).thenReturn(c1);

        CategoriaResponseDTO response = categoriaService.findByNome("Eletrônicos");

        assertNotNull(response);
        assertEquals("Eletrônicos", response.nome());
    }

    @Test
    void deveLancarExcecaoQuandoNomeNaoExistir() {
        when(categoriaRepository.existsByNome("Inexistente")).thenReturn(false);

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> categoriaService.findByNome("Inexistente")
        );

        assertEquals("Não existe categoria com este nome", exception.getMessage());
    }

    // ===================== createCategoria =====================

    @Test
    void deveCriarCategoriaComSucesso() {
        CategoriaRequestDTO dto = new CategoriaRequestDTO("Games");

        when(categoriaRepository.existsByNome(dto.nome())).thenReturn(false);

        CategoriaResponseDTO response = categoriaService.createCategoria(dto);

        assertNotNull(response);
        assertEquals("Games", response.nome());
        verify(categoriaRepository).save(any(Categoria.class));
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaJaExistirAoCriar() {
        CategoriaRequestDTO dto = new CategoriaRequestDTO("Eletrônicos");

        when(categoriaRepository.existsByNome(dto.nome())).thenReturn(true);

        AlreadyExistsException exception = assertThrows(
                AlreadyExistsException.class,
                () -> categoriaService.createCategoria(dto)
        );

        assertEquals("Já existe categoria com este nome", exception.getMessage());
    }

    // ===================== updateCategoria =====================

    @Test
    void deveAtualizarCategoriaComSucesso() {
        CategoriaRequestDTO dto = new CategoriaRequestDTO("Tecnologia");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(categoriaRepository.existsByNome(dto.nome())).thenReturn(false);

        CategoriaResponseDTO response = categoriaService.updateCategoria(1L, dto);

        assertEquals("Tecnologia", response.nome());
        verify(categoriaRepository).save(c1);
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoExistirAoAtualizar() {
        CategoriaRequestDTO dto = new CategoriaRequestDTO("Novo Nome");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> categoriaService.updateCategoria(1L, dto)
        );

        assertEquals("Categoria inexistente", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoNomeJaExistirAoAtualizar() {
        CategoriaRequestDTO dto = new CategoriaRequestDTO("Eletrônicos");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(c1));
        when(categoriaRepository.existsByNome(dto.nome())).thenReturn(true);

        AlreadyExistsException exception = assertThrows(
                AlreadyExistsException.class,
                () -> categoriaService.updateCategoria(1L, dto)
        );

        assertEquals("Já existe uma categoria com este nome", exception.getMessage());
    }

    // ===================== deleteCategoria =====================

    @Test
    void deveDeletarCategoriaComSucesso() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(c1));

        categoriaService.deleteCategoria(1L);

        verify(categoriaRepository).delete(c1);
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoExistirAoDeletar() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> categoriaService.deleteCategoria(1L)
        );

        assertEquals("Categoria inexistente", exception.getMessage());
    }
}
