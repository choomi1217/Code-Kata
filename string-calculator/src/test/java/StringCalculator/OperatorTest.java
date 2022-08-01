package StringCalculator;

import StringCalulator.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

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

        assertThat(actual).isEqualTo(-7.0);
    }

    @Test
    void 곱하기_연산() {
        Operator multiple = Operator.findBy('*');

        double actual = multiple.apply(3, 10);
        assertThat(actual).isEqualTo(30.0);
    }

    @Test
    void 나누기_연산() {
        Operator devide = Operator.findBy('/');

        double actual = devide.apply(9, 3);
        assertThat(actual).isEqualTo(3.0);
    }
}
