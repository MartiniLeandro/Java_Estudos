package com.consultaMedica.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especialidade;
    private Long crm;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public Medico(String nome, String especialidade, Long crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
