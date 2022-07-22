package StringCalulator;

import java.util.function.BinaryOperator;

public enum Operator {

    PLUS('+', Double::sum),
    MINUS('-', (left, right) -> left - right),
    MULTIPLE('*', (left, right) -> left * right),
    DEVIDE('/', (left, right) -> left / right);

    private final char operand;
    private final BinaryOperator<Double> binaryOperator;

    Operator(char operand, BinaryOperator<Double> binaryOperator) {
        this.operand = operand;
        this.binaryOperator = binaryOperator;
    }

    public static Operator findBy(char operand) {
        switch (operand) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return MULTIPLE;
            case '/':
                return DEVIDE;
            default:
                throw new IllegalArgumentException(" 예상된 값이 아닙니다");
        }
    }

    public double apply(double i, double i1) {
        return binaryOperator.apply(i, i1);
    }
}
