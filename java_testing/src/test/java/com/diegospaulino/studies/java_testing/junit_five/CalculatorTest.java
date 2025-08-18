package com.diegospaulino.studies.java_testing.junit_five;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Testes de operações matemáticas na classe Calculator")
public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executando o metodo setup antes de todos os testes");
    }

    @AfterAll
    static void cleanUp() {
        System.out.println("Executando o metodo cleanUp apos todos os testes");
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

    @DisplayName("Testando subtração com injeção de parâmetros [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
    @MethodSource()
    void integerSubtractionInputParameters(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Executando o teste integerSubtractionInputParameters");
        System.out.println("Teste: " + minuend + " - " + subtrahend + " = " + expectedResult);
        // Act: Executa a ação que será testada //When
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

        // Assert: Verifica se o resultado é o esperado //Then
        assertEquals(expectedResult, actualResult, () -> minuend + "-" + subtrahend + " não produziu o resultado esperado de " + expectedResult);

    }

    private static Stream<Arguments> integerSubtractionInputParameters() {
        return Stream.of(
            Arguments.of(33, 1, 32),
            Arguments.of(10, 5, 5),
            Arguments.of(20, 10, 10),
            Arguments.of(100, 50, 50),
            Arguments.of(0, 0, 0)
        );
    }

    @DisplayName("Testando adição com injeção de parâmetros [augend, addend, expectedResult]")
    @ParameterizedTest
    // @CsvSource({
    //     "1, 1, 2",
    //     "2, 3, 5",
    //     "10, 20, 30",
    //     "100, 200, 300",
    //     "0, 0, 0"
    // })
    // @CsvSource({"apple, orange",
    //             "apple, ''",
    //             "apple, "})
    @CsvFileSource(resources = "/addition_test_data.csv")
    void integerAddition(int augend, int addend, int expectedResult) {
        System.out.println("Executando o teste integerAddition");
        System.out.println("Teste: " + augend + " + " + addend + " = " + expectedResult);
        // Arrange: Configura o ambiente de teste //Given

        // Act: Executa a ação que será testada //When
        int actualResult = calculator.integerAddition(augend, addend);

        // Assert: Verifica se o resultado é o esperado //Then
        assertEquals(expectedResult, actualResult, () -> augend + " + " + addend + " não produziu o resultado esperado de " + expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Diego", "João", "Maria", "Ana"})
    void valueSourceDemonstration(String firstName) {
        System.out.println("Executando o teste valueSourceDemonstration");
        System.out.println("Teste: " + firstName);
        // Aqui você pode adicionar lógica para testar o valor fornecido
        // Por exemplo, verificar se o nome não está vazio ou nulo
        assertNotNull(firstName);

    }
}
