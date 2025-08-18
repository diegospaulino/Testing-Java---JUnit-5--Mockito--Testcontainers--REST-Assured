package com.diegospaulino.studies.java_testing.junit_five;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodsOrderedRandomlyTest {

    @Test
    void testA() {
        System.out.println("Executando o teste A");
    }

    @Test
    void testB() {
        System.out.println("Executando o teste B");
    }

    @Test
    void testC() {
        System.out.println("Executando o teste C");
    }

    @Test
    void testD() {
        System.out.println("Executando o teste D");
    }
}
