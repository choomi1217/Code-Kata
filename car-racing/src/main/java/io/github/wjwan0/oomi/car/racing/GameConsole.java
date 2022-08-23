package io.github.wjwan0.oomi.car.racing;

import io.github.wjwan0.oomi.car.racing.in.ConsoleIn;
import io.github.wjwan0.oomi.car.racing.out.ConsoleOut;

public class GameConsole {

    private final ConsoleIn in = new ConsoleIn();
    private final ConsoleOut out = new ConsoleOut();

    public void init() {

        String makeCars = in.makeCars();


        try {
            Cars cars = Cars.from(makeCars);

            int gameCount = in.askingGameCount();

            System.out.println("실행 결과");
            playGame(cars, gameCount);
            System.out.println("결과 출력");
            out.carsState(cars);
            out.resultOut(cars.getWinnerCarList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            init();
        } finally {
            in.closeScanner();
        }


    }

    private void playGame(Cars cars, int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            cars.run();
            out.carsState(cars);
        }
    }
}
