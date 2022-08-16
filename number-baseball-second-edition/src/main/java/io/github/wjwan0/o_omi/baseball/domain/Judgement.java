package io.github.wjwan0.o_omi.baseball.domain;

import io.github.wjwan0.o_omi.baseball.domain.balls.Ball;
import io.github.wjwan0.o_omi.baseball.domain.player.Player;

import java.util.List;

public class Judgement {

    private final Score score;

    public Judgement(Player computerUser, Player humanUser) {
        this.score = makeScore(computerUser, humanUser);
    }

    private Score makeScore(Player computerUser, Player humanUser) {
        int strikeCount;
        int ballCount;

        List<Ball> computerUserBallList = computerUser.getBalls();
        List<Ball> humanUserBallList = humanUser.getBalls();

        strikeCount = getStrikeCount(computerUserBallList, humanUserBallList);
        ballCount = getBallCount(computerUserBallList, humanUserBallList) - strikeCount;

        return new Score(strikeCount, ballCount);
    }


    private int getBallCount(List<Ball> computerUserBallList, List<Ball> humanUserBallList) {
        return (int) computerUserBallList.stream()
                .map(humanUserBallList::contains)
                .filter(aBoolean -> aBoolean)
                .count();
    }

    private int getStrikeCount(List<Ball> computerUserBallList, List<Ball> humanUserBallList) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerUserBallList.get(i).number() == humanUserBallList.get(i).number()) strikeCount++;
        }
        return strikeCount;
    }

    public Score getScore() {
        return score;
    }

    public boolean gameCheck() {
        return score.threeStrike();
    }
}
