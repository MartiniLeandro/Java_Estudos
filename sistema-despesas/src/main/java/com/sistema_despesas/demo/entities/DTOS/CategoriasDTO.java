package com.sistema_despesas.demo.entities.DTOS;

import com.sistema_despesas.demo.entities.utils.TipoCategoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CategoriasDTO(Long id, String nome,TipoCategoria tipoCategoria) {
}
