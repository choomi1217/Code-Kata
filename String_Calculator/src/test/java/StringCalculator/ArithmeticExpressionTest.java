package StringCalculator;

import StringCalulator.ArithmeticExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticExpressionTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "3 + 5",
            "13 + 5 - 4",
            "63 + 5 / 2",
            "1233 + 5 * 3 / 3",
            "53 - 661",
            "1"
    })
    void 올바른_연산식이면_예외를_발생하지_않는다(String expression) {
        Assertions.assertThatCode(() -> new ArithmeticExpression(expression))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "-3 + 5",
            "5 + + 4",
            "5 _ 5",
            "5 a 10",
            "50 - 13 + + 1",
            "5 x 10",
            "50 * * 13 + + 1",
            "-1"
    })
    void 올바르지_않은_연산식이면_예외를_발생한다(String expression) {
        Assertions.assertThatThrownBy(() -> new ArithmeticExpression(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "4 + 5 / 0 + 5",
            "4 / 0"
    })
    void 숫자0으로_나누면_예외가_발생한다(String expression) {
        Assertions.assertThatThrownBy(() -> new ArithmeticExpression(expression))
                .isInstanceOf(ArithmeticException.class);
    }
}
