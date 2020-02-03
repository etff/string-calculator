package kr.team.stringcalculator;

import java.util.Optional;

public class StringCalculator {
    public int add(String input) {
        // TODO 구현.
        if (input.contains("-")) System.exit(0);

        Optional<String> value = Optional.ofNullable(input);
        if (!value.isPresent()) return 0;

        int result = 0;
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if ('0' <= aChar && aChar <= '9') {
                result += Integer.parseInt(String.valueOf(aChar));
            }
        }
        return 0;
    }
}
