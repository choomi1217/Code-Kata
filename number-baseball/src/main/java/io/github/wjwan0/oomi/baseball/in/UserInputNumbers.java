package io.github.wjwan0.oomi.baseball.in;

import io.github.wjwan0.oomi.baseball.Numbers;

import java.util.Scanner;

public class UserInputNumbers {
    static final Scanner scanner = new Scanner(System.in);
    private Numbers numbers = null;

    public UserInputNumbers() {
        //입력받고, 검증하고, Numbers에 담아주기
        while (this.numbers == null) {
            try {
                this.numbers = Numbers.specificNumbers(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public boolean inputRestart() {
        int result = scanner.nextInt();
        scanner.nextLine();

        if (result == 1) {
            return true;
        }
        if (result == 2) {
            return false;
        }
        throw new IllegalArgumentException("정확한 값이 입력되지 않았습니다.");
    }
}
