package io.github.wjwan0.o_omi.car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "angmi,young,mi,wan,joo:5",
            "angmi,young,mi:3",
            "wan,joo:2"
    }, delimiter = ':')
    void 입력한_이름_갯수_만큼_자동차_생성(String inputName, int count) {
        Cars cars = new Cars(inputName);
        Assertions.assertThat(cars.getCarList().size()).isEqualTo(count);
    }

}
