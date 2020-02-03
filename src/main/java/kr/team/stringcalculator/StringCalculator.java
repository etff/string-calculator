package kr.team.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String input) {
        if(isBlack(input)){
            return 0;
        }
        int sum = 0;
        if(input.contains(",")){
            String[] split = input.split(",|:");
            for(int i=0; i<split.length; i++){
                sum += Integer.parseInt(split[i]);
            }
            return sum;
        }else{
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.find()){
                String customDelimeter = matcher.group(1);
                String[] split = matcher.group(2).split(customDelimeter);
                for(int i=0; i<split.length; i++){
                    sum += Integer.parseInt(split[i]);
                }
                return sum;
            }
        }
        return Integer.parseInt(input);
    }

    private boolean isBlack(String input){
        return input == null || input.isEmpty();
    }
}
