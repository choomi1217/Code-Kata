package io.github.wjwan0.o_omi.car_racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(String inputs) {
        List<String> collect = Arrays.stream(inputs.split(","))
                .map(String::trim)
                .toList();
        String[] names = collect.toArray(new String[0]);
//        String[] names = inputs.split(",");

        this.carList = Arrays.stream(names)
                .map(name -> new Car(name, new MoveImpl()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public void move() {
        carList.forEach(Car::moveForwardCheck);
    }

    public List<Car> getWinnerCarList() {
        ArrayList<Car> cars = new ArrayList<>(carList);
        cars.sort(Car::compareTo);

        Car winner = cars.get(0);
        return cars.stream()
                .filter(car -> winner.getForwardState().length() == car.getForwardState().length())
                .toList();
    }

}
