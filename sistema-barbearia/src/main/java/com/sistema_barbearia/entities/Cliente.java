package com.sistema_barbearia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class Cliente {

    private String nome;
    private String telefone;
    private final List<String> agendamentos;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cliente(String nome, String telefone, List<String> agendamentos, User user) {
        this.nome = nome;
        this.telefone = telefone;
        this.agendamentos = agendamentos;
        this.user = user;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getAgendamentos() {
        return agendamentos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
