package io.github.wjwan0.oomi.baseball.out;

import io.github.wjwan0.oomi.baseball.domain.Score;

public class ConsoleOut {

    public void output(Score score){
        System.out.println(score);
    }

    public void restartOutput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
