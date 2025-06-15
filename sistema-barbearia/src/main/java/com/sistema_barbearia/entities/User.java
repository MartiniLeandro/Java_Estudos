package com.sistema_barbearia.entities;

import com.sistema_barbearia.entities.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    public User(){}
    public User(String nome, String email, String senha, Roles roles) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.roles == Roles.ADMIN) return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_CLIENTE"),
                new SimpleGrantedAuthority("ROLE_BARBEIRO"));
        if(this.roles == Roles.BARBEIRO) return List.of(new SimpleGrantedAuthority("ROLE_BARBEIRO"));
        return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
