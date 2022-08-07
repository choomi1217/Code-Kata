package io.github.wjwan0.o_omi.baseball.in;

import io.github.wjwan0.o_omi.baseball.domain.player.Player;

import java.util.Arrays;
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
        String userInput = scan.nextLine();
        try {
            validation(userInput);
            int[] userInputArray =
                    Arrays.stream(userInput.split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            return Player.user(userInputArray);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputs();
        }
    }

    private static void validation(String userInput) {

        if (userInput.contains(" ")) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("공은 3개만 입력할 수 있습니다.");
        }
        if (!userInput.matches("\\d{3}")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}
