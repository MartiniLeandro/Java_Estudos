package com.demo.entities.DTOS;

import com.demo.entities.ENUMS.Status;

public record ProdutoUpdateDTO(String nome, Double preco, Long idCategoria, Status status) {

}

