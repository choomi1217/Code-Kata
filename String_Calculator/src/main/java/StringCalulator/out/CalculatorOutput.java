package StringCalulator.out;

import java.io.BufferedWriter;
import java.io.IOException;

public class CalculatorOutput {
    private final BufferedWriter bw;

    public CalculatorOutput(BufferedWriter bw) {
        this.bw = bw;

    }

    public void print(double result) throws IOException {
        bw.write(String.valueOf(result));
        bw.close();
    }

}
