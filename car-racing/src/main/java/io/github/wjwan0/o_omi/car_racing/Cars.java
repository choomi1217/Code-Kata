package io.github.wjwan0.o_omi.car_racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(String inputs) {
        String[] names = inputs.split(",");

        this.carList = Arrays.stream(names)
                .map(s -> new Car(s, new MoveImpl()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public void move() {
        carList.forEach(Car::moveForwardCheck);
    }

    public List<Car> sort() {
        ArrayList<Car> cars = new ArrayList<>(carList);
        cars.sort(Car::compareTo);
        return cars;
    }

}
