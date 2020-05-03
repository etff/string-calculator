package kr.team.stringcalculator.utils;

import kr.team.stringcalculator.Number;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberParser {
    private static final Pattern CUSTOM_DELIMTER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMETER = ",|:";
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";
    private static final int MATCHING_PART = 1;
    private static final int DELIMETER_FORMULA = 2;

    private NumberParser() {
    }

    public static List<String> splitText(String text) {
        Matcher matcher = CUSTOM_DELIMTER_PATTERN.matcher(text);
        if (matcher.find()) {
            return getCustomDelimeterText(matcher);
        }

        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static List<String> getCustomDelimeterText(Matcher matcher) {
        String delimiter = matcher.group(MATCHING_PART);
        return Stream.of(matcher.group(DELIMETER_FORMULA).split(delimiter))
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
