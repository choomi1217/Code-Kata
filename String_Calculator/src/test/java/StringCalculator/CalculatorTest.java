package StringCalculator;

import StringCalulator.ArithmeticExpression;
import StringCalulator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "3 + 5:8",
            "13 + 5 - 4:14",
            "63 + 5 / 2:34",
            "1233 + 5 * 3 / 3:1238",
            "53 - 661:-608",
            " 8 + 1 :9",
            " 9 / 2 *3 :13.5",
    }, delimiter = ':')
    void 계산_테스트(String args, double result) throws IOException {
        ArithmeticExpression arithmeticExpression = ArithmeticExpression.of(args);
        Calculator calculator = Calculator.of(arithmeticExpression);
        double actual = calculator.calculation();
        Assertions.assertThat(actual).isEqualTo(result);
    }
}