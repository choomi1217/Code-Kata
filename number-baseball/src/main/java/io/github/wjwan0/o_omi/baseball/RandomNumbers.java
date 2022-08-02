package io.github.wjwan0.o_omi.baseball;

import java.util.Random;

import static java.util.stream.Collectors.joining;

final class RandomNumbers implements Numbers {
    private final String value;

    RandomNumbers() {
        this.value = new Random()
                .ints(1, 10)
                .distinct()
                .limit(3)
                .mapToObj(String::valueOf)
                .collect(joining());
    }

    @Override
    public String threeNumbers() {
        return value;
    }
}
