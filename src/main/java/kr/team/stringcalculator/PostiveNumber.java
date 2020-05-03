package kr.team.stringcalculator;

public class PostiveNumber {
    private static final String NUMBER_SHOULD_POSITIVE = "0보다 큰 값을 입력해야합니다.";
    private int number;

    public PostiveNumber(int number) {
        this.number = validate(number);
    }

    public int getNumber() {
        return number;
    }

    public PostiveNumber sum(PostiveNumber postiveNumber) {
        return new PostiveNumber(this.number + postiveNumber.number);
    }

    private int validate(int number) {
        if (number < 0) {
            throw new NumberFormatException(NUMBER_SHOULD_POSITIVE);
        }
        return number;
    }

}
