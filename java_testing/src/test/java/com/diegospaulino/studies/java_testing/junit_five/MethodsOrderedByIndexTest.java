package com.diegospaulino.studies.java_testing.junit_five;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByIndexTest {

    @Order(1)
    @Test
    void testD() {
        System.out.println("Executando o teste D");
    }

    @Order(2)
    @Test
    void testA() {
        System.out.println("Executando o teste A");
    }

    @Order(3)
    @Test
    void testC() {
        System.out.println("Executando o teste C");
    }

    @Order(4)
    @Test
    void testB() {
        System.out.println("Executando o teste B");
    }
}
