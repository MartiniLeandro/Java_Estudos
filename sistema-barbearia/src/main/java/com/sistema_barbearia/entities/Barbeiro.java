package com.sistema_barbearia.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

public class Barbeiro{

    private String nome;
    private LocalDate inicioTrabalho;
    private LocalDate finalTrabalho;
    private final List<String> agendamentos;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Barbeiro(String nome, LocalDate inicioTrabalho, LocalDate finalTrabalho, List<String> agendamentos) {
        this.nome = nome;
        this.inicioTrabalho = inicioTrabalho;
        this.finalTrabalho = finalTrabalho;
        this.agendamentos = agendamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

}
