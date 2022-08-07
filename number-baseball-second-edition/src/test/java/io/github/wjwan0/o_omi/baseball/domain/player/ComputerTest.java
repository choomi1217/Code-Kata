package io.github.wjwan0.o_omi.baseball.domain.player;

import io.github.wjwan0.o_omi.baseball.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void 랜덤공이_3개_만들어진다() {
        Assertions.assertThat(Player.computer().getBalls().size()).isEqualTo(3);
    }
}
