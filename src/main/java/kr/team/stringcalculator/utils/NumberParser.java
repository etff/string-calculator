package kr.team.stringcalculator.utils;

import kr.team.stringcalculator.Number;

import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";

    private NumberParser() {
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
        } catch (ArithmeticException e) {
            throw new ArithmeticException(NOT_NUMBER + e.getMessage());
        }
    }
}
