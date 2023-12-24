package com.mkhatana.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    private Day1(){}

    public static String filterDigits(String input) {
        StringBuilder s = new StringBuilder();
        for(Character c : input.toCharArray()) {
            if(Character.isDigit(c)) {
                s.append(c);
            }
        }
        return s.toString();
    }

    public static int concatenateFirstAndLastDigit(String input) {
        return Integer.valueOf(input.substring(0, 1) + input.substring(input.length() - 1, input.length()));
    }

    public static int sumCalibrations(List<Integer> calibrations) {
        return calibrations.stream().reduce(0, (a,b)-> (a+b));
    }

    public static int completeChallenge(List<String> input) {
        List<Integer> allIntegers = new ArrayList<>();
        for (String line : input) {
            String filterDigits = filterDigits(line);
            int concatenated = concatenateFirstAndLastDigit(filterDigits);
            allIntegers.add(concatenated);
        }
        return sumCalibrations(allIntegers);
    }
}
