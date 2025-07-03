package com.testes.demo;

import com.testes.demo.entities.Person;
import com.testes.demo.service.IPersonService;
import com.testes.demo.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    Person person,actual;
    IPersonService service;

    @BeforeEach
    void setup(){
        service = new PersonService();
        person = new Person("Leandro", "Martini", "leandro@email.com", "Floripa - SC", "Masculino");
        actual = service.createPerson(person);
    }

    @Test
    @DisplayName("Success Create Person")
    void testCreatePerson(){
        Assertions.assertNotNull(actual, () -> "o método createPerson não pode retornar null");
    }

    @Test
    @DisplayName("Success when Person has FirstName")
    void testFirstName(){
        Assertions.assertEquals(person.getNome(),actual.getNome(), () -> "o nome deve ser o mesmo");
    }

    @Test
    @DisplayName("Success when Person has SecondName")
    void testSecondName(){
        Assertions.assertEquals(person.getSobrenome(),actual.getSobrenome(), () -> "o sobrenome deve ser o mesmo");
    }

    @Test
    @DisplayName("Success when Person has Email")
    void testEmail(){
        Assertions.assertEquals(person.getEmail(),actual.getEmail(), () -> "o email deve ser o mesmo");
    }

    @Test
    @DisplayName("Success when Person has Adress")
    void testAdress(){
        Assertions.assertEquals(person.getAdress(),actual.getAdress(), () -> "o adress deve ser o mesmo");
    }

    @Test
    @DisplayName("Success when Person has Genero")
    void testGenero(){
        Assertions.assertEquals(person.getGenero(),actual.getGenero(), () -> "o genero deve ser o mesmo");
    }

    @Test
    @DisplayName("Testando IllegalArgumentException")
    void testException(){
        person.setEmail(null);
        String expectedMessage = "O email não pode estar nulo";
        IllegalArgumentException erro = Assertions.assertThrows(IllegalArgumentException.class,() -> service.createPerson(person), () -> "O email não pode estar nulo");
        Assertions.assertEquals(expectedMessage, erro.getMessage(),() -> "mensagens incorretas!");
    }
}
