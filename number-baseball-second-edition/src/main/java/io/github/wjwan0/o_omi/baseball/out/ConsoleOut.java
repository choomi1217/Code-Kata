package io.github.wjwan0.o_omi.baseball.out;

public class ConsoleOut {

    public void output(String score){
        System.out.println(score);
    }

    public void restartOutput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
