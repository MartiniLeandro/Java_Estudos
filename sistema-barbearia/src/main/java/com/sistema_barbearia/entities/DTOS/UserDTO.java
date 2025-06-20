package com.sistema_barbearia.entities.DTOS;

import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.entities.enums.Roles;

public class UserDTO {
    private Long id;
    private String nome;
    private String email;
    private Roles role;

    public UserDTO(User user){
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.role = user.getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
