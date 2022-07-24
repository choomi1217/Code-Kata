package StringCalulator;

import java.util.ArrayDeque;

public class Calculator {

    private final ArrayDeque<String> accumulate;

    public Calculator(ArrayDeque<String> accumulate) {
        this.accumulate = accumulate;
    }

    public double calculation() {

        while (accumulate.size() != 1) {
            double left = Double.parseDouble(accumulate.poll());
            char center = accumulate.poll().charAt(0);
            double right = Double.parseDouble(accumulate.poll());
            double res = Operator.findBy(center).apply(left, right);
            accumulate.addFirst(String.valueOf(res));
        }
        return 0;
    }
}
