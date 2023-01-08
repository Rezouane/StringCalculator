package com.exalt.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorKataTest {

    private static final StringCalculatorKata STRING_CALCULATOR_KATA = new StringCalculatorKata();

    @Test
    void emptyStringTest() {
        assertEquals(0, STRING_CALCULATOR_KATA.add(""));
    }

    @Test
    void nullStringTest() {
        String s = null;
        assertEquals(0, STRING_CALCULATOR_KATA.add(s));
    }

    @Test
    void simpleSumTest() {
        assertEquals(3, STRING_CALCULATOR_KATA.add("1,2"));
    }

    @Test
    void multipleSumTest() {
        assertEquals(15, STRING_CALCULATOR_KATA.add("1,2,3,4,5"));
    }

    @Test
    void newLineSumTest() {
        assertEquals(6, STRING_CALCULATOR_KATA.add("1,2\n3"));
    }

    @Test
    void newLineErrorSumTest() {
        assertThrows(UnsupportedOperationException.class, () -> STRING_CALCULATOR_KATA.add("1,2,\n3"));
    }

    @Test
    void newDelimiterSumTest() {
        assertEquals(6, STRING_CALCULATOR_KATA.add("//;\n1;2\n3"));
    }

    @Test
    void negativeSumErrorTest() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> STRING_CALCULATOR_KATA.add("-1,2\n-3"));
        assertEquals("negatives not allowed : -1 -3", exception.getMessage());
    }
}