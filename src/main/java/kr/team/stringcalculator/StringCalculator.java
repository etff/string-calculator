package kr.team.stringcalculator;

import java.util.Optional;

public class StringCalculator {
    public int add(String input) {
        Optional<String> value = Optional.ofNullable(input);
        if (!value.isPresent()|| value==null) return 0;
        int sum = 0;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if ('0' <= c && c <= '9') {
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        return sum;
    }
}
