package com.diegospaulino.studies.java_testing.junit_five;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void integerDivision() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4, 2);

        // Assert that the result is as expected
        assertEquals(2, result, "O resultado dessa ação tem que ser 2"); 
    }
}
