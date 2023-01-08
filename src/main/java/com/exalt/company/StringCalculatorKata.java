package com.exalt.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculatorKata {

    int add(String numbers) {
        if (numbers == null || numbers.equals("")) {
            return 0;
        }

        String[] lineSplitedNumbers = splitLines(numbers);

        String delimiter = extractDelimiter(lineSplitedNumbers);

        if (!delimiter.equals(",")) {
            lineSplitedNumbers = removeFirstLine(lineSplitedNumbers);
        }

        checkSyntax(lineSplitedNumbers, delimiter);
        checkNegativeNumbers(lineSplitedNumbers, delimiter);

        return Arrays.stream(extractNumbers(splitNumbers(concatLines(lineSplitedNumbers, delimiter), delimiter))).sum();

    }

    private String[] removeFirstLine(String[] lines) {
        return Arrays.copyOfRange(lines, 1, lines.length);
    }

    private String concatLines(String[] numbers, String delimiter) {
        return String.join(delimiter, numbers);
    }

    private String extractDelimiter(String[] lines) {
        return lines[0].contains("//") ? lines[0].substring(lines[0].lastIndexOf("/") + 1) : ",";
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

    private void checkNegativeNumbers(String[] lines, String delimiter) {
        Boolean isNegative = false;
        StringBuilder message = new StringBuilder("negatives not allowed :");
        int[] numbers = null;
        for (String s : lines) {
            if (s.contains("-")) {
                numbers = extractNumbers(splitNumbers(s, delimiter));
                if (!isNegative) {
                    isNegative = true;
                }
                for (int num : numbers) {
                    if (num < 0) {
                        message.append(" " + num);
                    }
                }
            }
        }

        if (isNegative) {
            throw new UnsupportedOperationException(message.toString());
        }
    }
}
