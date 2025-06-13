package com.consultaMedica.entities;

public enum Roles {
    ADMIN("admin"),
    PACIENTE("paciente"),
    MEDICO("medico");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

}
