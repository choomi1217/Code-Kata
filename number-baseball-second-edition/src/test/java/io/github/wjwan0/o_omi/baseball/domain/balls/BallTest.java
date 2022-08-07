package io.github.wjwan0.o_omi.baseball.domain.balls;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    void 양수를_입력하면_예외가_발생하지_않는다() {
        Assertions.assertThatCode(() -> new Ball(5))
                .doesNotThrowAnyException();
    }

    @Test
    void 음수를_입력하면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Ball(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
