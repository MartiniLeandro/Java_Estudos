package com.SistemaBilioteca_springboot.models.enums;

public enum LeitorRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    LeitorRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
