package kr.team.stringcalculator.utils;

import kr.team.stringcalculator.Number;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberParser {
    private static final String DELIMETER = ",|:";
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";

    private NumberParser() {
    }

    public static List<String> splitText(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Number> convertToNumbers(List<String> text) {
        return text.stream()
                .map(NumberParser::parseToInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private static int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_NUMBER + e.getMessage());
        }
    }
}
