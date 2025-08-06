package com.diegospaulino.studies.java_testing.junit_five;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes de operações matemáticas na classe Calculator")
public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executando o metodo setup antes de todos os testes");
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Executando o metodo cleanUp após todos os testes");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executando o metodo @BeforeEach");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executando o metodo @AfterEach");
        // Aqui você pode limpar ou reinicializar recursos, se necessário
    }

    //Template para dar nome os metodos de testes
    //test<O que vai ser testado>_<Condições ou mudança de estado>_<Resultado esperado>
    @DisplayName("Testando 4/2 = 2")
    @Test
    void testintegerDivision_WhenFourIsDividecByTwo_ShouldReturnTwo() {
        System.out.println("Executando o teste testintegerDivision_WhenFourIsDividecByTwo_ShouldReturnTwo");
        // Arrange: Configura o ambiente de teste //Given
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        // Act: Executa a ação que será testada //When
        int actualResult = calculator.integerDivision(dividend, divisor);

        // Assert: Verifica se o resultado é o esperado //Then
        assertEquals(expectedResult, actualResult, "O resultado dessa ação tem que ser 2");  
    }

    @DisplayName("Testando divisão por zero")
    @Test
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Executando o teste testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException");
        // Arrange: Configura o ambiente de teste //Given
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        // Act & Assert: Executa a ação que será testada //When
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.integerDivision(dividend, divisor);
        }, "Divisão por zero deve lançar uma exceção do tipo ArithmeticException");
        System.out.println(actualException.getMessage());
        // Assert: Verifica se o resultado é o esperado //Then
        assertEquals(expectedExceptionMessage, actualException.getMessage(), 
            "Mensagem de exceção não corresponde à esperada");
        //fail("Divisão por zero deve lançar uma exceção do tipo ArithmeticException");
    }

    @DisplayName("Testando subtração 33-1=32")
    @Test
    void testIntegerSubtraction() {
        System.out.println("Executando o teste testIntegerSubtraction");
        int minuend = 33;
        int subtrahend = 1;
        int expectedResult = 32;

        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        // Assert that the result is as expected
        //Aplicado lambda no início do texto da mensagem para que só seja executado se o teste falhar
        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " não produziu o resultado esperado de " + expectedResult);
    }
}
