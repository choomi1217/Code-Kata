package io.github.wjwan0.o_omi.car_racing.out;

import io.github.wjwan0.o_omi.car_racing.Car;
import io.github.wjwan0.o_omi.car_racing.Cars;

import java.util.List;

public class ConsoleOut {

    public void carsState(Cars cars) {
        cars.getCarList()
                .forEach(System.out::println);
        System.out.println();
    }

    public void resultOut(List<Car> winnerCarList){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < winnerCarList.size(); i++) {
            makeWinnerOutput(winnerCarList, result, i);
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
