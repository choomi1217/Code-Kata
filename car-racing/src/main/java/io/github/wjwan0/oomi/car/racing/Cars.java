package io.github.wjwan0.oomi.car.racing;

import java.util.ArrayList;
import java.util.Arrays;
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
        // todo stream으로 max값 뽑아올수있음.
        ArrayList<Car> cars = new ArrayList<>(carList);
        cars.sort(Car::compareTo);

        Car winner = cars.get(0);
        return cars.stream()
                .filter(car -> winner.getForwardState().length() == car.getForwardState().length())
                .toList();
    }

}
