package io.github.wjwan0.oomi.baseball.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 중복_값을_제거_후_3개면_예외를_발생하지_않는다() {
        Assertions.assertThatCode(() -> Player.user("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 중복_값을_제거_후_3개가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Player.user("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_것을_입력하면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Player.user("12ㄴ"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자_3개를_입력하지_않으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> Player.user("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
