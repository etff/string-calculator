package kr.team.stringcalculator;


import kr.team.stringcalculator.utils.NumberParser;

import java.util.List;

public class StringCalculator {
    public int add(String input) {
        if (checkIsEmpty(input)) {
            return 0;
        }
        List<String> splitText = NumberParser.splitText(input);
        PostiveNumbers postiveNumbers = new PostiveNumbers(NumberParser.convertToNumbers(splitText));

        return postiveNumbers.sum();
    }

    private boolean checkIsEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
