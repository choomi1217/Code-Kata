package io.github.wjwan0.o_omi.baseball;

import java.util.List;
import java.util.random.RandomGenerator;

final class Computer implements Player{

    private final Balls balls;

    Computer() {
        balls = Balls.of(RandomGenerator.getDefault()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .toArray());
    }

    @Override
    public List<Ball> getBalls() {
        return balls.getBalls();
    }
}
