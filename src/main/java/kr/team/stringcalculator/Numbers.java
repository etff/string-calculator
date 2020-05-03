package kr.team.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public Integer sum() {
        return numbers.stream()
                .reduce(new Number(0), Number::sum)
                .getNumber();
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(getNumbers(), numbers1.getNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumbers());
    }
}
