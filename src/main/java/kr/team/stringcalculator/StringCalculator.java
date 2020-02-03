package kr.team.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if(isBlack(input)){
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private boolean isBlack(String input){
        return input == null || input.isEmpty();
    }

    private int sum(int[] numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private String[] split(String input){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(matcher.find()){
            String customDelimeter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimeter);
            return values;
        }
        return input.split(",|:");
    }

    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0; i<values.length; i++){
            numbers[i] += Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
