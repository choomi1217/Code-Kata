import StringCalulator.ArithmeticExpression;
import StringCalulator.Calculator;
import StringCalulator.in.CalculatorInput;
import StringCalulator.out.CalculatorOutput;

import java.io.IOException;

/*
 * 정적팩토리메소드
 * 팩토리패턴을 사용해서 객체 생성부분 만들고, 그 부분 적용하기
 * */
public class CalculatorRunner {
    static void run() throws IOException {
        ArithmeticExpression arithmeticExpression = ArithmeticExpression.of(CalculatorInput.userInput());
        Calculator calculator = Calculator.of(arithmeticExpression);
        CalculatorOutput.print(String.valueOf(calculator.calculation()));
    }
}
