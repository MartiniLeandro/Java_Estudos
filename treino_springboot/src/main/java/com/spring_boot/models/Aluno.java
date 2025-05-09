package com.spring_boot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alunos")
public class Aluno extends Pessoa{

    public Aluno(){}

    public Aluno(Long id, String nome,String email,Integer idade){
        super(nome, email, idade);
     }

     
}
