package com.sistema_barbearia.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Barbeiro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate inicioTrabalho;
    private LocalDate finalTrabalho;
    private final List<String> agendamentos;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Barbeiro(LocalDate inicioTrabalho, LocalDate finalTrabalho, List<String> agendamentos) {
        this.inicioTrabalho = inicioTrabalho;
        this.finalTrabalho = finalTrabalho;
        this.agendamentos = agendamentos;
    }


    public LocalDate getInicioTrabalho() {
        return inicioTrabalho;
    }

    public void setInicioTrabalho(LocalDate inicioTrabalho) {
        this.inicioTrabalho = inicioTrabalho;
    }

    public LocalDate getFinalTrabalho() {
        return finalTrabalho;
    }

    public void setFinalTrabalho(LocalDate finalTrabalho) {
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
}
