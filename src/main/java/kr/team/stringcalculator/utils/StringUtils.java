package kr.team.stringcalculator.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    private static final Pattern CUSTOM_DELIMTER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMETER = ",|:";
    private static final int MATCHING_PART = 1;
    private static final int DELIMETER_FORMULA = 2;

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
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
}
