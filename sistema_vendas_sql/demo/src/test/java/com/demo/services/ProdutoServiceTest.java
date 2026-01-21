package com.demo.services;

import com.demo.entities.Categoria;
import com.demo.entities.DTOS.ProdutoCreateDTO;
import com.demo.entities.DTOS.ProdutoResponseDTO;
import com.demo.entities.DTOS.ProdutoUpdateDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.entities.Produto;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.IncorrectPriceException;
import com.demo.exceptions.NotFoundException;
import com.demo.repositories.CategoriaRepository;
import com.demo.repositories.ProdutoRepository;
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
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private ProdutoService produtoService;

    private Categoria categoria;
    private Produto produto;

    @BeforeEach
    void setup() {
        categoria = new Categoria("Categoria Teste");
        produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(100.0);
        produto.setCategoria(categoria);
        produto.setStatus(Status.ATIVO);
    }

    // ===================== findAllProdutos =====================

    @Test
    void deveRetornarTodosProdutos() {
        when(produtoRepository.findAll()).thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result = produtoService.findAllProdutos();

        assertEquals(1, result.size());
        verify(produtoRepository).findAll();
    }

    // ===================== findById =====================

    @Test
    void deveRetornarProdutoPorId() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        ProdutoResponseDTO response = produtoService.findById(1L);

        assertNotNull(response);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoEncontrado() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> produtoService.findById(1L)
        );

        assertEquals("Produto não encontrado", exception.getMessage());
    }

    // ===================== findAllByIdCategoria =====================

    @Test
    void deveRetornarProdutosPorCategoria() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(produtoRepository.findByCategoria(categoria)).thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result = produtoService.findAllByIdCategoria(1L);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoExistir() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> produtoService.findAllByIdCategoria(1L)
        );
    }

    // ===================== findAllByPreco =====================

    @Test
    void deveRetornarProdutosPorPreco() {
        when(produtoRepository.findByPreco(100.0)).thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result = produtoService.findAllByPreco(100.0);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForInvalido() {
        assertThrows(
                IncorrectPriceException.class,
                () -> produtoService.findAllByPreco(0.0)
        );
    }

    // ===================== findAllBetweenPreco =====================

    @Test
    void deveRetornarProdutosEntrePrecos() {
        when(produtoRepository.findByPrecoBetween(50.0, 150.0)).thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result =
                produtoService.findAllBetweenPreco(50.0, 150.0);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoMinMaiorQueMax() {
        assertThrows(
                IncorrectPriceException.class,
                () -> produtoService.findAllBetweenPreco(200.0, 100.0)
        );
    }

    // ===================== findAllBetweenPrecoByCategoria =====================

    @Test
    void deveRetornarProdutosEntrePrecosPorCategoria() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(produtoRepository.findByCategoriaAndPrecoBetween(categoria, 50.0, 150.0))
                .thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result =
                produtoService.findAllBetweenPrecoByCategoria(50.0, 150.0, 1L);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoExistirNoFiltroPorPreco() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> produtoService.findAllBetweenPrecoByCategoria(50.0, 150.0, 1L)
        );
    }

    // ===================== findAllByStatus =====================

    @Test
    void deveRetornarProdutosPorStatus() {
        when(produtoRepository.existsByStatus(Status.ATIVO)).thenReturn(true);
        when(produtoRepository.findByStatus(Status.ATIVO)).thenReturn(List.of(produto));

        List<ProdutoResponseDTO> result =
                produtoService.findAllByStatus(Status.ATIVO);

        assertEquals(1, result.size());
    }

    @Test
    void deveLancarExcecaoQuandoStatusNaoExistir() {
        when(produtoRepository.existsByStatus(Status.valueOf("ATIVO"))).thenReturn(false);

        assertThrows(
                NotFoundException.class,
                () -> produtoService.findAllByStatus(Status.valueOf("ATIVO"))
        );
    }

    // ===================== createProduto =====================

    @Test
    void deveCriarProdutoComSucesso() {
        ProdutoCreateDTO dto = new ProdutoCreateDTO(
                "Produto Novo",
                200.0,
                1L
        );

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(produtoRepository.existsByNomeIgnoreCase(dto.nome())).thenReturn(false);

        ProdutoResponseDTO response = produtoService.createProduto(dto);

        assertNotNull(response);
        verify(produtoRepository).save(any(Produto.class));
    }

    @Test
    void deveLancarExcecaoQuandoNomeJaExistirAoCriarProduto() {
        ProdutoCreateDTO dto = new ProdutoCreateDTO(
                "Produto Teste",
                200.0,
                1L
        );

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(produtoRepository.existsByNomeIgnoreCase(dto.nome())).thenReturn(true);

        assertThrows(
                AlreadyExistsException.class,
                () -> produtoService.createProduto(dto)
        );
    }

    // ===================== updateProduto =====================

    @Test
    void deveAtualizarProdutoComSucesso() {
        ProdutoUpdateDTO dto = new ProdutoUpdateDTO(
                "Produto Atualizado",
                150.0,
                1L,
                Status.ATIVO
        );

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(produtoRepository.existsByNomeIgnoreCase(dto.nome())).thenReturn(false);

        ProdutoResponseDTO response = produtoService.updateProduto(dto, 1L);

        assertNotNull(response);
        verify(produtoRepository).save(produto);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistirAoAtualizar() {
        ProdutoUpdateDTO dto = new ProdutoUpdateDTO(
                "Produto",
                100.0,
                1L,
                Status.ATIVO
        );

        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> produtoService.updateProduto(dto, 1L)
        );
    }

    // ===================== deleteProduto =====================

    @Test
    void deveDeletarProdutoComSucesso() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        produtoService.deleteProduto(1L);

        verify(produtoRepository).delete(produto);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistirAoDeletar() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                NotFoundException.class,
                () -> produtoService.deleteProduto(1L)
        );
    }
}
