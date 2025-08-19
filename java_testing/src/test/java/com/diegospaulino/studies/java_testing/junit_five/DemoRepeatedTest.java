package com.diegospaulino.studies.java_testing.junit_five;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executando o metodo @BeforeEach");
        calculator = new Calculator();
    }

    @DisplayName("Testando divisão por zero")
    @RepeatedTest(value = 3, name = "{displayName}. Repeticao {currentRepetition} de {totalRepetitions}")
    void testIntegerDivision_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(
        RepetitionInfo repetitionInfo, TestInfo testInfo) {
        
        System.out.println("Executando o teste " + testInfo.getTestMethod().get().getName());
        System.out.println("Repeticao #" + repetitionInfo.getCurrentRepetition() + " de " + repetitionInfo.getTotalRepetitions());
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

}
