package io.github.wjwan0.oomi.baseball.domain.balls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    private Balls(int[] ballArray) {
        balls = Arrays.stream(ballArray)
                .mapToObj(Ball::new)
                .toList();
    }

    public static Balls of(int[] inputBalls) {
        return new Balls(inputBalls);
        // todo 빈배열 처리
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(this.balls);
    }
}
