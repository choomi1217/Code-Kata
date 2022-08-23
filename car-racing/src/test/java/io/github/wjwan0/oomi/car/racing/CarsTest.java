package io.github.wjwan0.oomi.car.racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "angmi,young,mi,wan,joo:5",
            "angmi,young,mi:3",
            "wan,joo:2"
    }, delimiter = ':')
    void 입력한_이름_갯수_만큼_자동차_생성(String inputName, int count) {
        Cars cars = Cars.from(inputName);
        Assertions.assertThat(cars.getCarList().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("등수 확인 테스트")
    void 등수_테스트() {
        //given
        Cars cars = Cars.from("완주,영미,거니");

        //when
        cars.run();
        cars.run();
        cars.run();
        cars.run();
        cars.run();
        cars.run();

        //then
        List<Car> plyaerRanking = cars.getPlyaerRanking();
        System.out.println("plyaerRanking = " + plyaerRanking.toString());
    }

}
