package kr.team.stringcalculator;


import kr.team.stringcalculator.utils.NumberParser;

import java.util.List;

public class StringCalculator {
    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        List<String> splitText = NumberParser.splitText(input);
        PostiveNumbers postiveNumbers = new PostiveNumbers(NumberParser.convertToNumbers(splitText));

        return postiveNumbers.sum();
    }
}
