package StringCalulator.in;

import java.io.BufferedReader;
import java.io.IOException;

public class CalculatorInput {
    private final BufferedReader br;
    private final String userInput;

    public CalculatorInput(BufferedReader br) throws IOException {
        this.br = br;
        this.userInput = br.readLine();
        br.close();
    }

    public String getUserInput(){
        return userInput;
    }
}
