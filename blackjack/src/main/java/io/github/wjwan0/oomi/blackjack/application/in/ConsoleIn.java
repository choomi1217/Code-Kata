package io.github.wjwan0.oomi.blackjack.application.in;

import java.util.Scanner;

public class ConsoleIn {

    private final static Scanner scanner = new Scanner(System.in);

    public String enterGamerName() {
        return scanner.nextLine();
    }

    public int betting() {
        return scanner.nextInt();
    }

    public boolean askMoreCard() {
        String answer = scanner.nextLine();
        try {
            return validationCheck(answer);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return askMoreCard();
        }
    }

    private boolean validationCheck(String answer) {
        if (!(answer.equals("y") || answer.equals("n"))) {
            throw new IllegalArgumentException("대답은 \"y\" 혹은 \"n\"으로만 대답해야 합니다.");
        }
        return answer.equals("y");
    }
}
