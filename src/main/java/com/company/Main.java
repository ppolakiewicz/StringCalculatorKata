package com.company;

import java.util.Arrays;

public class Main {

    private static final String DELIMITER_MARKER = "//";

    public static void main(String[] args) {
	// write your code here
    }

    public static int add(String numbers){
        if(numbers.isEmpty()) return 0;
        if(numbers.endsWith("\n")) throw new IllegalArgumentException();

        DelimiterDTO delimiterDTO;

        if(numbers.startsWith(DELIMITER_MARKER))
            delimiterDTO = getDelimiter(numbers);
        else
            delimiterDTO = new DelimiterDTO(",", numbers);

        return add(delimiterDTO);
    }

    public static DelimiterDTO getDelimiter(String input){
        String[] splitResult = input.split("\n", 2);

        return new DelimiterDTO(
                splitResult[0].replace(DELIMITER_MARKER, ""),
                splitResult[1]
        );
    }

    private static int add(DelimiterDTO delimiterDTO){
        return Arrays.stream(delimiterDTO.getInput().split(delimiterDTO.getDelimiter()))
                .map(String::trim)
                .mapToInt(Integer::parseInt).sum();
    }

}
