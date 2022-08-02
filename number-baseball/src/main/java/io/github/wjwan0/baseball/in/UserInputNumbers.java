package io.github.wjwan0.baseball.in;

import io.github.wjwan0.baseball.Numbers;

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

    public int inputRestart() {
        int result = scanner.nextInt();
        scanner.nextLine();

        return result;
    }
}
