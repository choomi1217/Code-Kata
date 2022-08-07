package io.github.wjwan0.o_omi.baseball;

import java.util.Arrays;
import java.util.List;

final class User implements Player {

    private final Balls balls;

    User(int[] ints) {
        int[] distinctedIntsList = Arrays.stream(ints)
                .distinct()
                .toArray();
        //중복 제거 전 3개 이상은 입력받는곳에서 처리.
        if (distinctedIntsList.length != 3) {
            throw new IllegalArgumentException("공은 중복되지 않은 3개만 던질 수 있습니다.");
        }
        balls = Balls.of(ints);
    }

    @Override
    public List<Ball> getBalls() {
        return balls.getBalls();
    }
}
