package com.sistema_despesas.demo.entities.DTOS;

import com.sistema_despesas.demo.entities.Launch;
import com.sistema_despesas.demo.entities.User;

import java.util.List;

public class UserDTO {
    private final Long id;
    private String email;

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
