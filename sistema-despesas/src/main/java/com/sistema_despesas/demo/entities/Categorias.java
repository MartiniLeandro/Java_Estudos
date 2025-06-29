package com.sistema_despesas.demo.entities;

import com.sistema_despesas.demo.entities.utils.TipoCategoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCategoria tipoCategoria;

    public Categorias(){}
    public Categorias(String nome, TipoCategoria tipoCategoria) {
        this.nome = nome;
        this.tipoCategoria = tipoCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReceitaOuDespesa(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
}
