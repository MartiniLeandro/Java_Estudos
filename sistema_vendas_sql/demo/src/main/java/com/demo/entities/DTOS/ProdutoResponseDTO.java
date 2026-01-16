package com.demo.entities.DTOS;

import com.demo.entities.ENUMS.Status;
import com.demo.entities.Produto;

public record ProdutoResponseDTO(Long idProduto, String nome, Double preco, Status status, Long idCategoria) {
    public ProdutoResponseDTO(Produto data){
        this(
                data.getIdProduto(), data.getNome(), data.getPreco(), data.getStatus(), data.getCategoria().getIdCategoria()
        );
    }
}
