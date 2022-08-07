package io.github.wjwan0.o_omi.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    private Balls(int[] ballArray) {
        balls = new ArrayList<>();
        Arrays.stream(ballArray)
                .mapToObj(Ball::new)
                .forEach(this::addBall);
    }

    static public Balls of(int[] inputBalls) {
        return new Balls(inputBalls);
    }

    private void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(this.balls);
    }
}
