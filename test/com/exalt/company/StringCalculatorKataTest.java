package com.exalt.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {

    @Test
    void emptyStringTest() {
        StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();

        assertEquals(0, stringCalculatorKata.add(""));
    }

    @Test
    void nullStringTest() {
        StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();
        String s = null;
        assertEquals(0, stringCalculatorKata.add(s));
    }

    @Test
    void simpleSumTest() {
        StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();
        assertEquals(3, stringCalculatorKata.add("1,2"));
    }
}