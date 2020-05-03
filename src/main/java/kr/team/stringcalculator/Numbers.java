package kr.team.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> positiveNumbers) {
        this.numbers = new ArrayList<>(positiveNumbers);
    }

    public Integer sum() {
        return numbers.stream()
                .reduce(new Number(0), Number::sum)
                .getNumber();
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
