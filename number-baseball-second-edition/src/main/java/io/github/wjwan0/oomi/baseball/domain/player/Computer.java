package io.github.wjwan0.oomi.baseball.domain.player;

import io.github.wjwan0.oomi.baseball.domain.balls.Ball;
import io.github.wjwan0.oomi.baseball.domain.balls.Balls;

import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;

final class Computer implements Player {

    private final Balls balls;

    Computer() {
        List<Integer> integers = new java.util.ArrayList<>(RandomGenerator.getDefault()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .boxed()
                .toList());

        Collections.shuffle(integers);
        int[] array = integers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        balls = Balls.of(array);
    }

    @Override
    public List<Ball> getBalls() {
        return balls.getBalls();
    }
}
