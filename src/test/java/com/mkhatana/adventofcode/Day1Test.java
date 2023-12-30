package com.mkhatana.adventofcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Day1Test {

    @ParameterizedTest(name = "filters digits - #{arguments}")
    @CsvSource({ "1abc2,12", "pqr3stu8vwx,38", "a1b2c3d4e5f,12345", "treb7uchet,7" })
    void filtersDigits(String input, String expected) {
        Assertions.assertEquals(expected, Day1.filterDigits(input));
    }

    @ParameterizedTest(name = "Concatenates first and last digits - #{arguments}")
    @CsvSource({ "1abc2,12", "pqr3stu8vwx,38", "a1b2c3d4e5f,15", "treb7uchet,77" })
    void concatenatesFirstAndLastDigit(String input, int expected) {
        Assertions.assertEquals(expected, Day1.concatenateFirstAndLastDigit(Day1.filterDigits(input)));
    }

    @Test
    void sumsAllCalibrations() {
        List<Integer> calibrations = List.of(12, 38, 15, 77);
        Assertions.assertEquals(142, Day1.sumCalibrations(calibrations));
    }

    @Test
    void completesFirstPartChallenge() {
        Assertions.assertEquals(142,
                Day1.completeChallengePart1(List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")));
    }

    @Test
    void outputsFirstPartChallengeTestResultFromInput() throws Exception {
        Assertions.assertEquals(55017, Day1.completeChallengePart1(getInput()));
    }

    List<String> getInput() throws IOException {

        ArrayList<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(Objects.requireNonNull(this.getClass()
                .getClassLoader()
                .getResource("Day1.input.txt")).getPath()))) {
            stream.forEach(list::add);
        }

        return list;
    }
}
