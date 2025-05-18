package com.SistemaBilioteca_springboot.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data não pode ser nula")
    private Instant dataEmprestimo;

    @OneToMany(mappedBy = "emprestimo")
    private List<LivroEmprestimo> livrosEmprestimo = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private Leitor leitor;

    public Emprestimo(){}
    public Emprestimo(Instant dataEmprestimo, Leitor leitor) {
        this.dataEmprestimo = dataEmprestimo;
        this.leitor = leitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Instant dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public List<LivroEmprestimo> getLivrosEmprestimo() {
        return livrosEmprestimo;
    }
}
