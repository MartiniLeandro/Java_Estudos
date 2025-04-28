package com.program;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        //Person p1 = new Person(null, "Bob Marley", "bob@gmail.com");
       //Person p2 = new Person(null, "Erick Marley", "erick@gmail.com");
       // Person p3 = new Person(null, "Pedro Marley", "pedro@gmail.com");

        Map<String, String> propriedades = new HashMap<>();
        propriedades.put("javax.persistence.jdbc.url", dotenv.get("DB_URL"));
        propriedades.put("javax.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa", propriedades);
        EntityManager em = emf.createEntityManager();

        Person p = em.find(Person.class, 2);
        System.out.println(p);

        //em.getTransaction().begin();
        //em.persist(p1);
        //em.persist(p2);
        //em.persist(p3);
        //em.getTransaction().commit();
        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}