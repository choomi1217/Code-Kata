package io.github.wjwan0.oomi.car.racing.out;

import io.github.wjwan0.oomi.car.racing.Car;
import io.github.wjwan0.oomi.car.racing.Cars;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;

public class ConsoleOut {

    public void carsState(Cars cars) {
        cars.getCarList()
                .forEach(System.out::println);
        System.out.println();
    }

    public void resultOut(List<Car> winnerCarList) {
        Queue<String> carNameQueue = winnerCarList.stream()
                .map(Car::getCarName)
                .collect(toCollection(LinkedList::new));

        StringBuilder result = new StringBuilder();
        while (carNameQueue.size() > 1) {
            result.append(String.format("%s, ", carNameQueue.poll()));
        }
        result.append(String.format("%s가 최종우승 했습니다.", carNameQueue.poll()));

        System.out.println(result);
    }

}
