package com.testes.demo;

import com.testes.demo.Classes.SimpleMath;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Fail.fail;

//@Order(2)ordem de execução de todos os testes
public class SimpleMathTest {

    SimpleMath math;
    String message = "O resultado esperado não é esse";

    @BeforeAll
    static void setup(){
        System.out.println("Executando @BeforeAll");
    }

    @BeforeEach
    void beforeEach(){
         math = new SimpleMath();
        System.out.println("Executando @BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Executando @AfterEach");
    }


    @AfterAll
    static void cleanup(){
        System.out.println("Executando @AfterAll");
    }


    @Test
    @DisplayName("Test 6.2 + 2.0 = 8.2")
    void testSoma_SeisPontoDoisMaisDois_DeveRetornarOitoPontoDois(){

        System.out.println("Executando teste1");
        //GIVEN
        Double firstNumber = 6.2;
        Double secondNumber = 2.0;
        //WHEN
        Double result = math.sum(firstNumber,secondNumber);
        //THEN
        Assertions.assertEquals(8.2, result, () -> message);
        Assertions.assertNotEquals(9.2, result);
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Test 8.0 - 4.0 = 4.0")
    void TestSubtraction_OitoMenosQuatro_DeveRetornarQuatro(){
        System.out.println("Executando teste2");
        Double result = math.subtraction(8.0,4.0);
        Assertions.assertEquals(4.0, result, () -> message);
    }

    @Test
    @DisplayName("Test 5.0 * 2.0 | 20.0 / 10.0 | RaizQuadrada de 124")
    void TestDivisionMediaRaizQuadrada(){
        System.out.println("Executando teste3");
        Double result = math.multiplication(5.0,2.0);
        Assertions.assertEquals(10.0,result, () -> message);

        Double resultDivision = math.division(20.0,10.0);
        Assertions.assertEquals(2.0,resultDivision, () -> message);

        Double resultMean = math.mean(5.0,9.0);
        Assertions.assertEquals(7.0,resultMean, () -> message);

        Double resultSquareRoot = math.squareRoot(124.0);
        Assertions.assertEquals(11.135528725660043, resultSquareRoot, () -> message);
    }

    @Test
    @DisplayName("Divisão por zero")
    void TestDivision_PrimeiroNumeroPorZero_DeveRetornarArithmeticalException(){

        Assertions.assertThrows(ArithmeticException.class, () -> math.division(4.0,0.0), () -> "Este teste deveria retornar um ArithmeticException");
    }

}
