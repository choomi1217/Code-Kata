package io.github.wjwan0.oomi.car.racing.in;

import io.github.wjwan0.oomi.car.racing.Cars;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleIn {

    private final static Scanner scanner = new Scanner(System.in);

    public Cars makeCars() {
        //todo 입력 외에 다른것도 하고있다.
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");

        try {
            return Cars.from(scanner.nextLine());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return makeCars();
        }
    }

    public int askingGameCount() {
        // todo sout이 있는게 이상함.
        System.out.println("시도할 회수는 몇회인가요?");

        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}
