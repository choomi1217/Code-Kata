package io.github.wjwan0.o_omi.baseball;

import io.github.wjwan0.o_omi.baseball.domain.Judgement;
import io.github.wjwan0.o_omi.baseball.domain.player.Player;
import io.github.wjwan0.o_omi.baseball.in.ConsoleIn;
import io.github.wjwan0.o_omi.baseball.out.ConsoleOut;

public class Main {
    public static void main(String[] args) {

        ConsoleIn consoleIn = new ConsoleIn();
        ConsoleOut consoleOut = new ConsoleOut();
        do {
            Player computer = Player.computer();
            game(consoleIn, consoleOut, computer);
            consoleOut.restartOutput();
        } while (consoleIn.restartGame());
    }

    private static void game(ConsoleIn consoleIn, ConsoleOut consoleOut, Player computer) {
        Judgement judgement;
        do {
            judgement = new Judgement(computer, consoleIn.inputs());
            consoleOut.output(judgement.getScore());
        } while (!judgement.gameCheck());
    }
}
