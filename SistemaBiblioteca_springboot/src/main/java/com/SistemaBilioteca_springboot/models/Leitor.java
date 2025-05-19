package com.SistemaBilioteca_springboot.models;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SistemaBilioteca_springboot.models.enums.LeitorRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "leitores")
public class Leitor implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O login não deve ser nulo")
    private String login;

    @NotBlank(message = "A senha não pode ser nula")
    private String senha;

    private LeitorRole role;

    @OneToMany(mappedBy = "leitor")
    private List<Emprestimo> emprestimos;

    public Leitor(){}
    public Leitor(String login, String senha, LeitorRole role) {
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LeitorRole getRole() {
        return role;
    }

    public void setRole(LeitorRole role) {
        this.role = role;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == LeitorRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_LEITOR"));
        else return List.of(new SimpleGrantedAuthority("ROLE_LEITOR"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    

    
}
