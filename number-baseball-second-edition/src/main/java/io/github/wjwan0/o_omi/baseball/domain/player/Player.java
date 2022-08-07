package io.github.wjwan0.o_omi.baseball.domain.player;

import io.github.wjwan0.o_omi.baseball.domain.balls.Ball;

import java.util.List;

public interface Player {

    List<Ball> getBalls();

    static Player computer() {
        return new Computer();
    }

    static Player user(int[] ballsArray) {
        return new User(ballsArray);
    }
}
