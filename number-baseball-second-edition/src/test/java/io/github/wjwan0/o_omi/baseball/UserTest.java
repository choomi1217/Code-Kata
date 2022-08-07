package io.github.wjwan0.o_omi.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {


    @Test
    void 중복_값을_제거_후_3개면_예외를_발생하지_않는다() {
        Assertions.assertThatCode(() -> Player.user(new int[]{1, 2, 3}))
                .doesNotThrowAnyException();
    }

    @Test
    void 중복_값을_제거_후_3개가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Player.user(new int[]{1, 2, 2}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
