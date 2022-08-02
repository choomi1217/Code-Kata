package io.github.wjwan0.o_omi.baseball.out;

import io.github.wjwan0.o_omi.baseball.Judgement;

public class ResultOutput {

    private final Judgement judgement;

    public ResultOutput(Judgement judgement) {
        this.judgement = judgement;
    }

    public void printResult() {
        System.out.println(getResult());
    }

    private String getResult() {
        // n볼 n스트라이크
        int ballCount = this.judgement.getBallCount();
        int strikeCount = this.judgement.getStrikeCount();
        if (ballCount == 0) {
            return strikeCount + " 스트라이크";
        }
        if (strikeCount == 0) {
            return ballCount + " 볼";
        }
        return ballCount + " 볼 " + strikeCount + " 스트라이크";
    }

    public void printRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
