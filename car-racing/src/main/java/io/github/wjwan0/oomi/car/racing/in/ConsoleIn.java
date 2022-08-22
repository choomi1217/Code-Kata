package io.github.wjwan0.oomi.car.racing.in;

import io.github.wjwan0.oomi.car.racing.out.ConsoleOut;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleIn {

    private final static Scanner scanner = new Scanner(System.in);

    private final ConsoleOut consoleOut = new ConsoleOut();

    public String makeCars() {
        consoleOut.printStart();
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    public int askingGameCount() {
        consoleOut.countAsk();
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
