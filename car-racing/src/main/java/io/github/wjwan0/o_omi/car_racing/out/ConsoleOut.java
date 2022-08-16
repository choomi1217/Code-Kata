package io.github.wjwan0.o_omi.car_racing.out;

import io.github.wjwan0.o_omi.car_racing.Cars;

public class ConsoleOut {

    public void carsState(Cars cars) {
        cars.getCarList()
                .forEach(System.out::println);
        System.out.println();
    }


}
