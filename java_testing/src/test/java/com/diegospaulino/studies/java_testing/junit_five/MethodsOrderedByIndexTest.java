package com.diegospaulino.studies.java_testing.junit_five;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByIndexTest {

    StringBuilder completed = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The state of instance object Completed is: " + completed);
    }

    @Order(1)
    @Test
    void testD() {
        System.out.println("Executando o teste D");
        completed.append("1");
    }

    @Order(2)
    @Test
    void testA() {
        System.out.println("Executando o teste A");
        completed.append("2");
    }

    @Order(3)
    @Test
    void testC() {
        System.out.println("Executando o teste C");
        completed.append("3");
    }

    @Order(4)
    @Test
    void testB() {
        System.out.println("Executando o teste B");
        completed.append("4");
    }
}
