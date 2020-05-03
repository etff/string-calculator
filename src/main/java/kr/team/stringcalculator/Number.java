package kr.team.stringcalculator;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Number sum(Number number) {
        return new Number(this.number + number.number);
    }
}
