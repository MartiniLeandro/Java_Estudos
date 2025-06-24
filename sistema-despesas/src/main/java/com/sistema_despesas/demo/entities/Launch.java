package com.sistema_despesas.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Launch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @NotNull
    private Categorias categoria;

    @NotNull
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Launch(){}
    public Launch(String description, Categorias categoria, Double valor, User user) {
        this.description = description;
        this.categoria = categoria;
        this.valor = valor;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public User getUser() {
        return user;
    }
}
