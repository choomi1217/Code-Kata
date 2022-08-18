package io.github.wjwan0.oomi.baseball.domain.player;

import io.github.wjwan0.oomi.baseball.domain.balls.Ball;

import java.util.List;

public interface Player {

    List<Ball> getBalls();

    static Player computer() {
        return new Computer();
    }

    static Player user(String ballsArray) {
        return new User(ballsArray);
    }
}
