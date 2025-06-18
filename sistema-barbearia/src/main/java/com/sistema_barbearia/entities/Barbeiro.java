package com.sistema_barbearia.entities;

import com.sistema_barbearia.repositories.BarbeiroRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barbeiro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String inicioTrabalho;

    @NotBlank
    private String finalTrabalho;

    private final List<String> agendamentos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Barbeiro(){}
    public Barbeiro(String inicioTrabalho, String finalTrabalho, User user) {
        this.inicioTrabalho = inicioTrabalho;
        this.finalTrabalho = finalTrabalho;
        this.user = user;
    }


    public String getInicioTrabalho() {
        return inicioTrabalho;
    }

    public void setInicioTrabalho(String inicioTrabalho) {
        this.inicioTrabalho = inicioTrabalho;
    }

    public String getFinalTrabalho() {
        return finalTrabalho;
    }

    public void setFinalTrabalho(String finalTrabalho) {
        this.finalTrabalho = finalTrabalho;
    }

    public List<String> getAgendamentos() {
        return agendamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
