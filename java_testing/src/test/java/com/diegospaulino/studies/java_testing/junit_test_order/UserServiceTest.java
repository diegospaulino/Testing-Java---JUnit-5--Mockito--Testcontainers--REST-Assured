package com.diegospaulino.studies.java_testing.junit_test_order;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
public class UserServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Primeiro...");
    }

    @Test
    void testOrderCreation() {
    }
}
