package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.Barbeiro;

import java.time.LocalTime;
import java.util.List;

public class AllBarbeirosDTO {
    private Long id;
    private LocalTime inicioTrabalho;
    private LocalTime finalTrabalho;
    private List<String> agendamentos;
    private UserDTO user;

    public AllBarbeirosDTO(Barbeiro barbeiro){
        this.id = barbeiro.getId();
        this.inicioTrabalho = barbeiro.getInicioTrabalho();
        this.finalTrabalho = barbeiro.getFinalTrabalho();
        this.agendamentos = barbeiro.getAgendamentos();
        this.user = new UserDTO(barbeiro.getUser());
    }

    public Long getId(){
        return this.id;
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

    public void setAgendamentos(List<String> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
