package io.github.wjwan0.oomi.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ScoreTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:1 스트라이크 2 볼",
            "3:0:3 스트라이크",
            "0:0:낫싱",
            "0:3:3 볼"
    }, delimiter = ':')
    void 점수_입력_테스트(int strike, int ball, String result) {
        Score score = new Score(strike, ball);
        Assertions.assertThat(score.toString())
                .isEqualTo(result);
    }
}
