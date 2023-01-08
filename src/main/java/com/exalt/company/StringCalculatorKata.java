package com.exalt.company;

import java.util.Arrays;

public class StringCalculatorKata {

    int add(String numbers) {
        if (numbers == null || numbers.equals("")) {
            return 0;
        }
        String delimiter = ",";

        String[] lineSplitedNumbers = splitLines(numbers);

        checkSyntax(lineSplitedNumbers, delimiter);

        return Arrays.stream(extractNumbers(splitNumbers(concatLines(lineSplitedNumbers, delimiter), delimiter))).sum();

    }

    private String concatLines(String[] numbers, String delimiter) {
        return String.join(delimiter, numbers);
    }

    private void checkSyntax(String[] numbers, String delimiter) {
        for (String s : numbers) {
            if (s.endsWith(delimiter)) {
                throw new UnsupportedOperationException("Syntax error");
            }
        }
    }

    private String[] splitLines(String numbers) {
        return numbers.split("\n");
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int[] extractNumbers(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}
