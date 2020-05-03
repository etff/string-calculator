package kr.team.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class PostiveNumbers {

    private final List<PostiveNumber> postiveNumbers;

    public PostiveNumbers(List<PostiveNumber> postiveNumbers) {
        this.postiveNumbers = new ArrayList<>(postiveNumbers);
    }

    public Integer sum() {
        return postiveNumbers.stream()
                .reduce(new PostiveNumber(0), PostiveNumber::sum)
                .getNumber();
    }

    public List<PostiveNumber> getPostiveNumbers() {
        return new ArrayList<>(postiveNumbers);
    }
}
