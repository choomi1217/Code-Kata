package StringCalulator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS('+', (left, right) -> left + right),
    MINUS('-', (left, right) -> left - right),
    MULTIPLE('*', (left, right) -> left * right),
    DIVIDE('/', (left, right) -> left / right),
    ;

    private final char operand;
    private final BinaryOperator<Double> binaryOperator;

    Operator(char operand, BinaryOperator<Double> binaryOperator) {
        this.operand = operand;
        this.binaryOperator = binaryOperator;
    }

    public static Operator findBy(char operand) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operand == operand)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

    public double apply(double left, double right) {
        if (this.operand == '/' && right == 0) throw new IllegalArgumentException(" 0으로 나눌 수 없습니다. ");
        return binaryOperator.apply(left, right);
    }
}
