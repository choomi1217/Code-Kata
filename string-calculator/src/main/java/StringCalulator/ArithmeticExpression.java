package StringCalulator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ArithmeticExpression {

    private final String expression;


    /**
     * /0을 포함하지 않고
     * 숫자가 오고 공백이 있거나 없거나
     * 연산자가 오고 공백이 있거나 없거나
     * 숫자로 끝나는 정규식
     */
//    private static final Pattern expressionRegexPattern = Pattern.compile("^(:?(?!.+/ ?0.*)\\d+ ?[+\\-*/] ?)+\\d+$");
    // ^\s*(:?(?!.+/ ?0.*)\d+ ?[+\-*/] ?)+\d+\s*$
    // " 8+1 "
    private static final Pattern expressionRegexPattern = Pattern.compile("^\\s*(:?(?!.+/ ?0.*)\\d+ *?[+\\-*/] *?)+\\d+\\s*$");

    private ArithmeticExpression(String expression) {
        validation(expression);
        this.expression = expression;
    }

    public static ArithmeticExpression of(String expression) {
        return new ArithmeticExpression(expression);
    }

    private void validation(String expression) {
        if (expression == null) throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        if (!expressionRegexPattern.matcher(expression).matches()) throw new IllegalArgumentException("정확한 값을 입력해주세요.");
    }

    /**
     * 정규식을 그룹화해서 라벨링하여 replace한다.
     */
    public ArrayDeque<String> getStackArray() {
        String[] splitExpression = expression
                .replaceAll(" ", "")
                .replaceAll("(?<number>\\d)(?<operator>[+\\-*/])", "${number} ${operator} ")
                .split(" ");

        return new ArrayDeque<>(Arrays.asList(splitExpression));
    }
}