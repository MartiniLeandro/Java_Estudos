package com.sistema_despesas.demo.entities.DTOS;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;

public class LaunchDTO {

    private final Long id;
    private String description;
    private Categorias categoria;
    private Double valor;
    private UserDTO user;

    public LaunchDTO(Launch launch){
        this.id = launch.getId();
        this.description = launch.getDescription();
        this.categoria = launch.getCategoria();
        this.valor = launch.getValor();
        this.user = new UserDTO(launch.getUser());
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
}
