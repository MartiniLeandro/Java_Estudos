package com.sistema_barbearia.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barbeiro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime inicioTrabalho;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime finalTrabalho;

    private final List<String> agendamentos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Barbeiro(){}
    public Barbeiro(LocalTime inicioTrabalho, LocalTime finalTrabalho, User user) {
        this.inicioTrabalho = inicioTrabalho;
        this.finalTrabalho = finalTrabalho;
        this.user = user;
    }


    public LocalTime getInicioTrabalho() {
        return inicioTrabalho;
    }

    public void setInicioTrabalho(LocalTime inicioTrabalho) {
        this.inicioTrabalho = inicioTrabalho;
    }

    public LocalTime getFinalTrabalho() {
        return finalTrabalho;
    }

    public void setFinalTrabalho(LocalTime finalTrabalho) {
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
