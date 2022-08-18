package io.github.wjwan0.oomi.baseball.in;

import io.github.wjwan0.oomi.baseball.domain.player.Player;

import java.util.Scanner;

public class ConsoleIn {
    private static final Scanner scan = new Scanner(System.in);

    public boolean restartGame() {
        boolean restartCheck = scan.nextInt() == 1;
        scan.nextLine();
        return restartCheck;
    }

    public Player inputs() {
        System.out.print("숫자를 입력해 주세요. : ");
        try {
            return Player.user(scan.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputs();
        }
    }

}
