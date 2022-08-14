package io.github.wjwan0.o_omi.car_racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MoveTest {

    @Test
    void 랜덤_객체로_생성하였을_때_예외가_발생하지_않는다() {
        assertThatCode(() -> new Move().isItMove())
                .doesNotThrowAnyException();
    }
}
