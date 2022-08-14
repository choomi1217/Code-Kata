package io.github.wjwan0.o_omi.car_racing;

import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class MakeRandom {

    private int randomeValue;

    public MakeRandom() {
        makeRandomState();
    }

    public void makeRandomState() {

        List<Integer> randomList = RandomGenerator.getDefault()
                .ints(0, 10)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomList);

        this.randomeValue = randomList.stream()
                .mapToInt(Integer::intValue)
                .findFirst()
                .orElseThrow();

    }

    public int getRandomeValue() {
        return randomeValue;
    }
}
