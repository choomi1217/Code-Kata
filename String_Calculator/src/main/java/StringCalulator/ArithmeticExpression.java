package StringCalulator;

public class ArithmeticExpression {

    private final String expression;

    public ArithmeticExpression(String expression) {
        validation(expression);
        this.expression = expression;
    }

    public String getExpression(){
        return this.expression;
    }

    private void validation(String expression) {
        String expressionRegex = "^(\\d+ [+\\-*/] )*\\d+$";
        String divideZeroRegex = ".*/\\s*0.*";

        if (expression == null) throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");

        if (!expression.matches(expressionRegex)) throw new IllegalArgumentException("정확한 값을 입력해주세요.");

        if (expression.matches(divideZeroRegex)) throw new ArithmeticException("0으로 나눌 수 없습니다.");

    }

}