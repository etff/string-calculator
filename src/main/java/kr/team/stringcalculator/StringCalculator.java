package kr.team.stringcalculator;


import kr.team.stringcalculator.utils.NumberParser;
import kr.team.stringcalculator.utils.StringUtils;

import java.util.List;

public class StringCalculator {
    public int add(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        List<String> splitText = StringUtils.splitText(input);
        Numbers numbers = new Numbers(NumberParser.convertToNumbers(splitText));

        return numbers.sum();
    }
}
