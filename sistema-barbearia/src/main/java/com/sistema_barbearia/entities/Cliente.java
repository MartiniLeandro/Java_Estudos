package com.sistema_barbearia.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefone;
    private final List<String> agendamentos;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cliente(String telefone, List<String> agendamentos, User user) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
