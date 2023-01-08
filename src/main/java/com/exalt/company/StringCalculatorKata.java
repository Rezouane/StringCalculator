package com.exalt.company;

import java.util.Arrays;

public class StringCalculatorKata {

    int add(String numbers) {
        if (numbers == null || numbers.equals("")) {
            return 0;
        }
        String delimiter = ",";

        return Arrays.stream(extractNumbers(splitNumbers(numbers, delimiter))).sum();

    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int[] extractNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}
