package io.github.wjwan0.oomi.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JudgementTest {

    @Test
    void 볼_체크() {
        Judgement baseBallJudgement = new Judgement(Numbers.specificNumbers("123"), Numbers.specificNumbers("132"));
        Assertions.assertThat(baseBallJudgement.getBallCount()).isEqualTo(2);
    }

    @Test
    void 스트라이크_체크() {
        Judgement baseBallJudgement = new Judgement(Numbers.specificNumbers("123"), Numbers.specificNumbers("132"));
        Assertions.assertThat(baseBallJudgement.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void _4볼체크() {
        Judgement baseBallJudgement = new Judgement(Numbers.specificNumbers("123"), Numbers.specificNumbers("567"));
        Assertions.assertThat(baseBallJudgement.getBallCount()).isEqualTo(4);
    }
}
