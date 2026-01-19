package com.demo.entities.DTOS;

import com.demo.entities.Categoria;

public record CategoriaResponseDTO(Long  idCategoria, String nome) {
    public CategoriaResponseDTO(Categoria categoria) {
        this(
                categoria.getIdCategoria(), categoria.getNome()
        );
    }
}
