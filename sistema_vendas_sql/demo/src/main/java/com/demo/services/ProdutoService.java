package com.demo.services;

import com.demo.entities.Categoria;
import com.demo.entities.DTOS.ProdutoCreateDTO;
import com.demo.entities.DTOS.ProdutoResponseDTO;
import com.demo.entities.DTOS.ProdutoUpdateDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.entities.Produto;
import com.demo.repositories.CategoriaRepository;
import com.demo.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoResponseDTO> findAllProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public ProdutoResponseDTO findById(Long id){
        return new ProdutoResponseDTO(produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado")));
    }

    public List<ProdutoResponseDTO> findAllByIdCategoria(Long IdCategoria){
        Categoria categoria = categoriaRepository.findById(IdCategoria).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        return produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public List<ProdutoResponseDTO> findAllByPreco(Double preco){
        List<Produto> produtos = produtoRepository.findByPreco(preco);
        return produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public List<ProdutoResponseDTO> findAllBetweenPreco(Double preco_min, Double preco_max){
        List<Produto> produtos = produtoRepository.findByPrecoBetween(preco_min, preco_max);
        return produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public List<ProdutoResponseDTO> findAllBetweenPrecoByCategoria(Double preco_min, Double preco_max, Long  idCategoria){
        Categoria categoria = categoriaRepository.findById(idCategoria).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        List<Produto> produtos = produtoRepository.findByCategoriaAndPrecoBetween(categoria,preco_min,preco_max);
        return  produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public List<ProdutoResponseDTO> findAllByStatus(Status status){
        List<Produto> produtos = produtoRepository.findByStatus(status);
        return produtos.stream().map(ProdutoResponseDTO::new).toList();
    }

    public ProdutoResponseDTO createProduto(ProdutoCreateDTO data){
        Categoria categoria = categoriaRepository.findById(data.idCategoria()).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        Produto produto = new Produto(data, categoria);
        produtoRepository.save(produto);
        return  new ProdutoResponseDTO(produto);
    }

    public ProdutoResponseDTO updateProduto(ProdutoUpdateDTO data, Long id){
        Produto updatedProduto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Categoria categoria = categoriaRepository.findById(data.idCategoria()).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        updatedProduto.setNome(data.nome());
        updatedProduto.setPreco(data.preco());
        updatedProduto.setCategoria(categoria);
        updatedProduto.setStatus(data.status());
        produtoRepository.save(updatedProduto);
        return  new ProdutoResponseDTO(updatedProduto);
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
