import StringCalulator.ArithmeticExpression;
import StringCalulator.Calculator;
import StringCalulator.in.CalculatorInput;
import StringCalulator.out.CalculatorOutput;

import java.io.*;

public class CalculatorRunner {
    public static void run() throws IOException {
        CalculatorInput input = new CalculatorInput(new BufferedReader(new InputStreamReader(System.in)));
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(input.getUserInput());
        Calculator calculator = new Calculator(arithmeticExpression.getStackArray());

        CalculatorOutput output = new CalculatorOutput(new BufferedWriter(new OutputStreamWriter(System.out)));
        output.print(calculator.calculation());
    }
}
