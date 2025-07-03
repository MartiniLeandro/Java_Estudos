package com.testes.demo;

import org.junit.jupiter.api.*;

//@Order(1)ordem de execução de todos os testes
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //mudando o ciclo de vida padrão
@TestMethodOrder(MethodOrderer.Random.class) //para confirmar que não haverá testes que dependem de outro
public class MethodRandomTest {

    @Test
    //@Order(1) caso utilizar o MethodOrderer por Order
    void testA(){
        System.out.println("Test A");
    }

    @Test
    void testB(){
        System.out.println("Test B");
    }

    @Test
    void testC(){
        System.out.println("Test C");
    }

    @Test
    void testD(){
        System.out.println("Test D");
    }
}
