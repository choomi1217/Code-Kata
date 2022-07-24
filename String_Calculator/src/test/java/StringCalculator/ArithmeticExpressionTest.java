package StringCalculator;

import StringCalulator.ArithmeticExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
            " 8 + 1 ",
            " 9 / 2 *3",
            " 9 /   2   *     3",

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
            "-1",
            "1"
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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3 + 5 :3",
            "13 + 5 - 4:5",
            "63 + 5 / 2:5",
            "1233 + 5 * 3 / 3:7",
            "53 - 661:3",
            " 8 + 1 :3",
            " 9 / 2 *3:5"
    }, delimiter = ':')
    void 연산자_피연산자_담기(String expression, int result) {
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(expression);
        Assertions.assertThat(arithmeticExpression.getStackArray().size()).isEqualTo(result);
    }
}
