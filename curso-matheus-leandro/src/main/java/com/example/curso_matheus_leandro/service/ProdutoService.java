package com.example.curso_matheus_leandro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.curso_matheus_leandro.models.Produto;
import com.example.curso_matheus_leandro.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    
}
