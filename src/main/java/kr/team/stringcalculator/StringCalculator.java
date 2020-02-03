package kr.team.stringcalculator;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
    public int add(String input) {

        if (!checkNull(input)) {
            int sum = 0;
            int[] nums = checkNumber(input);
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        return 0;
    }

    static int[] checkNumber(String input) {
        List<String> nums = new ArrayList<>();
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if ('0' <= c && c <= '9') {
                nums.add(c + "");
            }
        }
        return nums.stream().mapToInt(Integer::parseInt).toArray();
    }

    static boolean checkNull(String input) {
        Optional<String> value = Optional.ofNullable(input);
        if (!value.isPresent() || value == null) return true;
        return false;
    }
}
