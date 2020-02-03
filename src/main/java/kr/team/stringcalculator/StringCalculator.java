package kr.team.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
    public int add(String input) {
        if (!checkNull(input)) {
            return sum(checkNumber(input));
        }
        return 0;
    }
    private int sum (int[] nums) {
        return Arrays.stream(nums).sum();
    }
    private int[] checkNumber(String input) {
        List<String> nums = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if ('0' <= c && c <= '9') {
                nums.add(c + "");
            }
        }
        return nums.stream().mapToInt(Integer::parseInt).toArray();
    }
    private boolean checkNull(String input) {
        Optional<String> value = Optional.ofNullable(input);
        return (!value.isPresent() || value == null) ? true : false;
    }
}
