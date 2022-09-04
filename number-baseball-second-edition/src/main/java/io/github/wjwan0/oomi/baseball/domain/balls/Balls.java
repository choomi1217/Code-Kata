package io.github.wjwan0.oomi.baseball.domain.balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(int[] inputBalls) {
        List<Ball> balls = Arrays.stream(inputBalls)
                .mapToObj(Ball::new)
                .toList();

        return new Balls(balls);
        // todo 빈배열 처리
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(this.balls);
    }
}
