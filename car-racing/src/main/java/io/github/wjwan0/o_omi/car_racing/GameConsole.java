package io.github.wjwan0.o_omi.car_racing;

import io.github.wjwan0.o_omi.car_racing.in.ConsoleIn;
import io.github.wjwan0.o_omi.car_racing.out.ConsoleOut;

import java.util.List;

public class GameConsole {

    private final ConsoleIn in = new ConsoleIn();
    private final ConsoleOut out = new ConsoleOut();

    public void init() {

        Cars cars = in.makeCars();

        int gameCount = in.askingGameCount();


        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            cars.move();
            out.carsState(cars);
        }

        List<Car> sortCarList = cars.sort();
        Car winner = sortCarList.get(0);
        List<Car> winnerList = sortCarList.stream()
                .filter(car -> winner.getForwardState().length() == car.getForwardState().length())
                .toList();


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < winnerList.size(); i++) {
            makeWinnerOutput(winnerList, result, i);
        }

        System.out.println(result);
    }

    private void makeWinnerOutput(List<Car> winnerList, StringBuilder result, int last) {
        if (last != winnerList.size() - 1) {
            result.append(winnerList.get(last).getCarName()).append(", ");
            return;
        }
        result.append(winnerList.get(last).getCarName()).append("가 최종우승 했습니다.");
    }


}
