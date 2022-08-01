package io.github.wjwan0.baseball;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"12", "1234", "12 "})
    void mustBe3Numbers(String testcase) {
        assertThatThrownBy(() -> Numbers.specificNumbers(testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되지않는_숫자_세자리가_들어갔을_경우_예외를_발생하지_않는다() {
        assertThatCode(() -> Numbers.specificNumbers("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 랜덤숫자_만들기_테스트() {
        Numbers randomNumbers = Numbers.randomNumbers();
        System.out.println(randomNumbers.threeNumbers());
        Assertions.assertThat(randomNumbers.threeNumbers()).hasSize(3);
    }

    @Test
    void 스트라이크와_볼_판별_테스트(){
        String user = "123"; String computer = "345"; // 0strike 1ball
        //String user = "123" String computer = "124" // 2strike 0ball
        //String user = "123" String computer = "132" // 1strike 2ball

        Arrays.stream(user.split("")).fo

    }
}