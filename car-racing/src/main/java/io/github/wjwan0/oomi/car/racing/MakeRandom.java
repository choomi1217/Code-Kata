package io.github.wjwan0.oomi.car.racing;

import java.util.random.RandomGenerator;

public class MakeRandom {

    private long randomeValue;

    public MakeRandom() {
        makeRandomState();
    }

    public void makeRandomState() {
        this.randomeValue = RandomGenerator.getDefault()
                .longs(0, 10)
                .distinct()
                .limit(1)
                .findFirst()
                .orElseThrow();

    }

    public long getRandomeValue() {
        return randomeValue;
    }
}
