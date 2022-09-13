package io.github.wjwan0.oomi.blackjack.application.in;

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
        int bettingMoney = scanner.nextInt();
        scanner.nextLine();
        return bettingMoney;
    }

    public String askMoreCard() {
        String answer = scanner.nextLine();
        try {
            validationCheck(answer);
            return answer;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return askMoreCard();
        }
    }

    private void validationCheck(String answer) {
        if (!(answer.equals("y") || answer.equals("n"))) {
            throw new IllegalArgumentException("대답은 \"y\" 혹은 \"n\"으로만 대답해야 합니다.");
        }
    }
}
