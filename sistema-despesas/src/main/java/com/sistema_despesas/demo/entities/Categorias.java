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

    private TipoCategoria tipoCategoria;

    @OneToMany(mappedBy = "categoria")
    private ReceitasDespesas receitasDespesas;

    public Categorias(){}
    public Categorias(String nome, TipoCategoria tipoCategoria, ReceitasDespesas receitasDespesas) {
        this.nome = nome;
        this.tipoCategoria = tipoCategoria;
        this.receitasDespesas = receitasDespesas;
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

    public TipoCategoria getReceitaOuDespesa() {
        return this.tipoCategoria;
    }

    public void setReceitaOuDespesa(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public ReceitasDespesas getReceitasDespesas() {
        return receitasDespesas;
    }
}
