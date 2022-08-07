package io.github.wjwan0.o_omi.baseball.domain;

import io.github.wjwan0.o_omi.baseball.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JudgementTest {

    Player computerUser;

    @BeforeEach
    void newPlayer() {
        computerUser = Player.user(new int[]{1, 2, 3});
    }

    @ParameterizedTest
    @MethodSource("scoreTest")
    void 점수_체크_테스트(Player humanUser, Score score) {
        Assertions.assertThat(new Judgement(computerUser, humanUser).getScore()).isEqualTo(score.toString());
    }


    static Stream<Arguments> scoreTest() {
        return Stream.of(
                Arguments.of(Player.user(new int[]{1, 2, 3}), new Score(3, 0)),
                Arguments.of(Player.user(new int[]{1, 3, 2}), new Score(1, 2)),
                Arguments.of(Player.user(new int[]{3, 1, 2}), new Score(0, 3)),
                Arguments.of(Player.user(new int[]{4, 5, 6}), new Score(0, 0))
        );
    }
}
