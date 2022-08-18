package io.github.wjwan0.oomi.car.racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Move alwaysMove = () -> true;
    Move alwaysNotMove = () -> false;

    @ParameterizedTest
    @ValueSource(strings = {
            "abcde",
            "뛰뛰빵빵",
            "1234",
            "자동차",
            "make"
    })
    void 올바른_자동차이름을_입력하면_예외가_발생하지_않는다(String name) {
        assertThatCode(() -> new Car(name, alwaysMove))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "onetwothree",
            "",
            "뛰뛰빠빠바방",
            "abcdef",
            "a bc"

    })
    void 올바르지_않은_자동차_이름을_입력하면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Car(name, alwaysMove))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void move가_true면_전진이_1올라간다() {
        Car car = new Car("name", alwaysMove);

        car.moveForwardCheck();

        assertThat(car.getForwardState()).isEqualTo("-");
    }

    @Test
    void move가_false면_전진_상태값이_올라가지_않는다() {
        Car car = new Car("name", alwaysNotMove);

        car.moveForwardCheck();

        assertThat(car.getForwardState()).isEqualTo("");
    }

    @Test
    void 정렬_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("first", alwaysNotMove));
        cars.add(new Car("secon", alwaysMove));

        cars.forEach(Car::moveForwardCheck);
        cars.sort(Car::compareTo);

        assertThat(cars.get(0).getCarName()).isEqualTo("secon");

    }
}
