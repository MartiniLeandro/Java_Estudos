package com.demo.entities;

import com.demo.entities.DTOS.ProdutoCreateDTO;
import com.demo.entities.ENUMS.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "preco")
    private Double preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private Status status;

    public Produto() {}
    public Produto(String nome, Double preco, Categoria categoria, Status status) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.status = Status.ATIVO;
    }

    public Produto(ProdutoCreateDTO data, Categoria categoria) {
        this.nome = data.nome();
        this.preco = data.preco();
        this.categoria = categoria;
        this.status = Status.ATIVO;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
