package com.example.curso_matheus_leandro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso_matheus_leandro.Exceptions.RecursoNaoEncontradoException;
import com.example.curso_matheus_leandro.models.Produto;
import com.example.curso_matheus_leandro.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado"));
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    
}
