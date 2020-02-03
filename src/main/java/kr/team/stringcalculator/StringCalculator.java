package kr.team.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if(isBlack(input)){
            return 0;
        }
        if(input.contains(",")){
            String[] split = input.split(",|:");
            return sum(split);
        }else{
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.find()){
                String customDelimeter = matcher.group(1);
                String[] split = matcher.group(2).split(customDelimeter);
                return sum(split);
            }
        }
        return Integer.parseInt(input);
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
}
