package kr.team.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if(isBlack(input)){
            return 0;
        }
        return sum(split(input));
    }

    private boolean isBlack(String input){
        return input == null || input.isEmpty();
    }

    private int sum(String[] numbers){
        int sum = 0;
        for(int i=0; i<numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    private String[] split(String input){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(matcher.find()){
            String customDelimeter = matcher.group(1);
            String[] split = matcher.group(2).split(customDelimeter);
            return split;
        }
        return input.split(",|:");
    }
}
