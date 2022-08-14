package io.github.wjwan0.o_omi.car_racing;

public class MoveImpl implements Move {

    private final MakeRandom makeRandom;

    public MoveImpl() {
        this.makeRandom = new MakeRandom();
        validation(makeRandom.getRandomeValue());
    }

    private void validation(long move) {
        if (move < 0 || move > 9) {
            throw new IllegalArgumentException("0~9사이의 숫자만 올 수 있습니다.");
        }
    }

    public boolean isItMove() {
        makeRandom.makeRandomState();
        return makeRandom.getRandomeValue() >= 4;
    }

}
