package com.testes.demo.entities;

public class Person {
    private String nome;
    private String sobrenome;
    private String email;
    private String adress;
    private String genero;

    public Person(){}
    public Person(String nome, String sobrenome, String email, String adress, String genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.adress = adress;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
