package io.github.wjwan0.oomi.blackjack.application.in;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleIn {

    private final static Scanner scanner = new Scanner(System.in);

    public String enterGamerName() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("빈 값은 입력할 수 없습니다.");
            return enterGamerName();
        }
    }

    public int betting() {
        int bettingMoney;
        try {
            bettingMoney = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return betting();
        }
        scanner.nextLine();
        return bettingMoney;
    }

    public boolean askMoreCard() {
        String answer = scanner.nextLine();
        try {
            validationCheck(answer);
            return answer.equals("y");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askMoreCard();
        }
    }

    private void validationCheck(String answer) {
        if (!(answer.equals("y") || answer.equals("n"))) {
            throw new IllegalArgumentException("대답은 \"y\" 혹은 \"n\"으로만 대답해야 합니다.");
        }
    }
}
