package com.company;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DelimiterDTO {

    private final String delimiter;
    private final String input;

    public String getDelimiter() {
        return delimiter + "|\n";
    }

    public String getInput() {
        return input;
    }
}
