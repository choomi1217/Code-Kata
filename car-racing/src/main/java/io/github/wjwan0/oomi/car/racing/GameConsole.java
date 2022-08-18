package io.github.wjwan0.oomi.car.racing;

import io.github.wjwan0.oomi.car.racing.in.ConsoleIn;
import io.github.wjwan0.oomi.car.racing.out.ConsoleOut;

public class GameConsole {

    private final ConsoleIn in = new ConsoleIn();
    private final ConsoleOut out = new ConsoleOut();

    public void init() {

        Cars cars = in.makeCars();

        int gameCount = in.askingGameCount();
        in.closeScanner();

        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            cars.run();
            out.carsState(cars);
        }

        System.out.println("결과 출력");
        out.carsState(cars);

        out.resultOut(cars.getWinnerCarList());
    }
}
