package com.testes.demo;

import com.testes.demo.Classes.SimpleMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class simpleMathTest2 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @ParameterizedTest
    @ValueSource(strings = {"leandro", "gabriel", "thiago"}) //utilizado para apenas um parâmetro
    @DisplayName("Test com nomes")
    void testNames(String name){
        System.out.println(name);
        Assertions.assertNotNull(name);
    }


    @ParameterizedTest
    @CsvSource({"8.0,4.0,2.0","10.0,5.0,2.0"}) //pode ser utilizado para vários, ou apenas um parâmetro
    @DisplayName("divisão com parâmetros")
    void testDivision(double firstNumber, double secondNumber, double expected){
        Double result = math.division(firstNumber,secondNumber);
        Assertions.assertEquals(expected, result, () -> "valor incorreto");
    }
}
