package StringCalulator.out;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CalculatorOutput {

    public static void print(String result) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.close();
//        return new CalculatorOutput(bufferedWriter);
    }

}
