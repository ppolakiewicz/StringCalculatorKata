package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int add(String numbers){
        if(numbers.isEmpty()) return 0;

        return Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).sum();
    }
}
