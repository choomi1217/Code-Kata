package io.github.wjwan0.oomi.car.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(String inputs) {
        return new Cars(
                Arrays.stream(inputs.split(","))
                        .map(String::trim)
                        .map(name -> new Car(name, new MoveImpl()))
                        .collect(toList())
        );
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public void run() {
        carList.forEach(Car::moveForwardCheck);
    }

    public List<Car> getWinnerCarList() {
        ArrayList<Car> cars = new ArrayList<>(carList);
        Comparator<Car> carComparator = Comparator.comparingInt(Car::getForwardState);
        Car winnerCar = cars.stream()
                .max(carComparator)
                .orElseThrow();


        return cars.stream()
                .filter(car -> winnerCar.getForwardState() == car.getForwardState())
                .toList();
    }

}
