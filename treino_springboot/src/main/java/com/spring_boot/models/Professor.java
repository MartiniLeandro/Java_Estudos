package com.spring_boot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Professores")
public class Professor extends Pessoa{

    public Professor(){}

    public Professor(Long id, String nome,String email,Integer idade){
        super(nome, email, idade);
     }


}
