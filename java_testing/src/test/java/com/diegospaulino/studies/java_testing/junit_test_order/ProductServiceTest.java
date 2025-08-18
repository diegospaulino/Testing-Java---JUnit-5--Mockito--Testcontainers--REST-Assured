package com.diegospaulino.studies.java_testing.junit_test_order;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class ProductServiceTest {

    // @BeforeAll
    // static void setup() {
    //     System.out.println("Segundo...");
    // }

    @Test
    void testOrderCreation() {
        System.out.println("Segundo...");
    }
}
