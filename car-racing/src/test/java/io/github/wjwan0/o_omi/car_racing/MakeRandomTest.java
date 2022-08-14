package io.github.wjwan0.o_omi.car_racing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MakeRandomTest {

    @Test
    void makeRandomState() {
        for (int i = 0; i < 100; i++) {
            MakeRandom makeRandom = new MakeRandom();
            makeRandom.makeRandomState();

            boolean moveCheck = makeRandom.getRandomeValue() <= 9 && 0 <= makeRandom.getRandomeValue();

            assertTrue(moveCheck);
        }

    }
}