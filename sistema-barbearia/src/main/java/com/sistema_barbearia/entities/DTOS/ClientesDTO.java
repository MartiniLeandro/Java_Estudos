package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.Cliente;

import java.util.List;

public class ClientesDTO {
    private Long id;
    private String telefone;
    private List<String> agendamentos;
    private UserDTO user;

    public ClientesDTO(Cliente cliente){
        this.id = cliente.getId();
        this.telefone = cliente.getTelefone();
        this.agendamentos = cliente.getAgendamentos();
        this.user = new UserDTO(cliente.getUser());
    }

    public Long getId() {
        return id;
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
