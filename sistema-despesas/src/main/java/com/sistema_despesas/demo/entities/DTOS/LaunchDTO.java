package com.sistema_despesas.demo.entities.DTOS;

import com.sistema_despesas.demo.entities.Launch;

import java.time.LocalDate;

public class LaunchDTO {

    private Long id;
    private String description;
    private String categoria;
    private Double valor;
    private LocalDate data;

    public LaunchDTO(){}

    public LaunchDTO(Long id, String description, String categoria, Double valor, LocalDate data) {
        this.id = id;
        this.description = description;
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
    }
    public LaunchDTO(Launch launch){
        this.id = launch.getId();
        this.description = launch.getDescription();
        this.categoria = launch.getCategoria().getNome();
        this.valor = launch.getValor();
        this.data = launch.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria_id(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setLocalDateTime(LocalDate data) {
        this.data = data;
    }
}
