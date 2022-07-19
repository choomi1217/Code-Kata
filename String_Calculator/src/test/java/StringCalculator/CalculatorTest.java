package StringCalculator;

import StringCalulator.Operator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void 더하기_연산() {
        Operator plus = Operator.findBy('+');

        double actual = plus.apply(3, 10);

        assertThat(actual).isEqualTo(13.0);
    }

    @Test
    void 빼기_연산() {
        Operator minus = Operator.findBy('-');

        double actual = minus.apply(3, 10);
        //망주님 수고해써요~ ☺ 좋은밤 되세요!
        assertThat(actual).isEqualTo(-7.0);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 + 5",
    })
    void 곱하기_연산() {

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 + 5",
            "13 + 5 - 4",
            "63 + 5 / 2",
            "1233 + 5 * 3 / 3",
            "53 - 661",
    })
    void 나누기_연산() {

    }
}
