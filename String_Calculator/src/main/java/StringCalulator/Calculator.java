package StringCalulator;

import java.util.ArrayDeque;

public class Calculator {

    private final ArrayDeque<String> accumulate;

    private Calculator(ArrayDeque<String> accumulate) {
        this.accumulate = accumulate;
    }

    public static Calculator of(ArithmeticExpression arithmeticExpression){
        return new Calculator(arithmeticExpression.getStackArray());
    }

    @SuppressWarnings("all") // there will never be a problem
    public double calculation() {

<<<<<<< HEAD
        int count = 0;
        double sum = 0;

        while (!accumulate.isEmpty()) {

=======
        while (accumulate.size() != 1) {
            double left = Double.parseDouble(accumulate.poll());
            char center = accumulate.poll().charAt(0);
            double right = Double.parseDouble(accumulate.poll());
            double res = Operator.findBy(center).apply(left, right);
            accumulate.addFirst(String.valueOf(res));
>>>>>>> 90e02d9b5220f47a23d04c2892d5cddb9e6b24fa
        }
        return Double.parseDouble(accumulate.poll());
    }

}
