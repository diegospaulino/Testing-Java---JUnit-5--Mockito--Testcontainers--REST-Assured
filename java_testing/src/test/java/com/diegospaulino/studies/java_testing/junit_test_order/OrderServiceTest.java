package com.diegospaulino.studies.java_testing.junit_test_order;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(3)
public class OrderServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Terceiro...");
    }

    @Test
    void testOrderCreation() {
    }
}
