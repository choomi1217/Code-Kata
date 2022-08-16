package io.github.wjwan0.o_omi.baseball.domain.player;

import io.github.wjwan0.o_omi.baseball.domain.balls.Ball;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void 랜덤공이_3개_만들어진다() {
        //given
        Player computer = Player.computer();

        //when
        List<Ball> balls = computer.getBalls();

        //then
        assertThat(balls).hasSize(3);
    }
}
