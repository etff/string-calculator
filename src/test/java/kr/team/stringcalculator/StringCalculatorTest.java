package kr.team.stringcalculator;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new StringCalculator();
    }

    @DisplayName("빈값인지 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void testNullOrEmpty(final String input) {
        assertThat(calculator.add(input)).isZero();
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void testComma(final String text) {
        assertThat(calculator.add(text)).isSameAs(3);
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3"})
    void testColons(final String text) {
        assertThat(calculator.add(text)).isSameAs(6);
    }

}
