package com.treino_security_noJWT.entities;

public enum UserRoles{
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRoles(String role){
        this.role = role;
    }

    String getRole(){
        return this.role;
    }

}
