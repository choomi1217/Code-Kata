package application.in;

import java.util.Scanner;

public class ConsoleIn {

    private final static Scanner scanner = new Scanner(System.in);

    public long inputMoney() {
        return scanner.nextLong();
    }

    public String inputWinningNumbers() {
        return scanner.next();
    }

    public int inputBonusBall() {
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
