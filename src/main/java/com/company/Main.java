package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static final String NEGATIVES_MESSAGE = "negatives not allowed: ";

    private static final String DELIMITER_MARKER = "//";
    private static final int MAX_ITEM_VALUE = 1000;

    public static void main(String[] args) {
        // write your code here
    }

    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        if (numbers.endsWith("\n")) throw new IllegalArgumentException();

        DelimiterDTO delimiterDTO;
        if (numbers.startsWith(DELIMITER_MARKER))
            delimiterDTO = getDelimiter(numbers);
        else
            delimiterDTO = new DelimiterDTO(",", numbers);

        validateNegatives(delimiterDTO);
        return add(delimiterDTO);
    }

    public static DelimiterDTO getDelimiter(String input) {
        String[] splitResult = input.split("\n", 2);

        return new DelimiterDTO(
                splitResult[0].replace(DELIMITER_MARKER, ""),
                splitResult[1]
        );
    }

    private static int add(DelimiterDTO delimiterDTO) {
        return getIntStream(delimiterDTO)
                .filter(i -> i < MAX_ITEM_VALUE)
                .sum();
    }

    private static String getNegativeNumbers(DelimiterDTO delimiterDTO) {
        return getIntStream(delimiterDTO)
                .filter(i -> i < 0)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    private static IntStream getIntStream(DelimiterDTO delimiterDTO) {
        return Arrays.stream(delimiterDTO.getInput().split(delimiterDTO.getDelimiter()))
                .map(String::trim)
                .mapToInt(Integer::parseInt);
    }

    private static void validateNegatives(DelimiterDTO delimiterDTO){
        String negativeNumbers = getNegativeNumbers(delimiterDTO);

        if(negativeNumbers.length() > 0)
            throw new IllegalArgumentException(NEGATIVES_MESSAGE + negativeNumbers);
    }

}
