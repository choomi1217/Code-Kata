package io.github.wjwan0.baseball;

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
        Assertions.assertThat(randomNumbers.threeNumbers()).hasSize(3);
    }
}