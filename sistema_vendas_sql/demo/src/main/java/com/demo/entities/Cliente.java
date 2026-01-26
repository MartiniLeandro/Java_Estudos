package com.demo.entities;

import com.demo.entities.ENUMS.Role;
import com.demo.entities.ENUMS.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
public class Cliente implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "senha")
    private String password;

    @NotNull
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "role")
    private Role role;

    public Cliente() {
    }

    public Cliente(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.dataCadastro = LocalDateTime.now();
        this.status = Status.ATIVO;
        this.role = Role.USER;
    }

    public Long getId() {
        return idCliente;
    }

    public void setId(Long id) {
        this.idCliente = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.USER) return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new  SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
