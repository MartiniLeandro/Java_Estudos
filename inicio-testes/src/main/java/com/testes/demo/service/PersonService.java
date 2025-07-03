package com.testes.demo.service;

import com.testes.demo.entities.Person;

public class PersonService implements IPersonService{

    @Override
    public Person createPerson(Person person) {
        if(person.getEmail() ==  null){
            throw new IllegalArgumentException("O email não pode estar nulo");
        }
        return person;
    }
}
