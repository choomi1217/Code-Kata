package io.github.wjwan0.o_omi.baseball;

import io.github.wjwan0.o_omi.baseball.in.UserInputNumbers;
import io.github.wjwan0.o_omi.baseball.out.ResultOutput;

public class GameConsole {
    //메인말구! 메서드만들고! main에서 따로실행!
    //여기다가 Judgement, Random, User, Input, Output
    public static void main(String[] args) {
        Runner.init();
    }

    private static class Runner {

        public static void init() {
            new Runner().run();
        }

        public void run() {
            int strikeCount = 0;
            Numbers randomNumbers = Numbers.randomNumbers();
            ResultOutput output;
            UserInputNumbers userInputNumbers;
            do {
                userInputNumbers = new UserInputNumbers();
                Numbers userNumbers = userInputNumbers.getNumbers();
                Judgement judgement = new Judgement(randomNumbers, userNumbers);
                System.out.println("randomNumbers = " + randomNumbers.threeNumbers());
                strikeCount = judgement.getStrikeCount();
                output = new ResultOutput(judgement);
                output.printResult();
            } while (strikeCount != 3);

            output.printRestart();
            if (userInputNumbers.inputRestart() == 1) {
                System.out.println("게임을 다시 시작합니다.");
                run();
            }
            System.exit(0);
        }

    }

}

