package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.Barbeiro;

import java.time.LocalTime;

public class BarbeiroDTO {
    private Long id;
    private LocalTime inicioTrabalho;
    private LocalTime finalTrabalho;
    private UserDTO user;

    public BarbeiroDTO(Barbeiro barbeiro){
        this.id = barbeiro.getId();
        this.inicioTrabalho = barbeiro.getInicioTrabalho();
        this.finalTrabalho = barbeiro.getFinalTrabalho();
        this.user = new UserDTO(barbeiro.getUser());
    }

    public Long getId() {
        return id;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
