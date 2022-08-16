package io.github.wjwan0.o_omi.baseball.domain.player;

import io.github.wjwan0.o_omi.baseball.domain.balls.Ball;
import io.github.wjwan0.o_omi.baseball.domain.balls.Balls;

import java.util.Arrays;
import java.util.List;

final class User implements Player {

    private final Balls balls;

    User(String inputs) {
        int[] userInputArray = validation(inputs);
        balls = Balls.of(userInputArray);
    }

    private int[] validation(String inputs) {

        int[] userInputArray = userInputArray(inputs);

        if (!inputs.matches("\\d{3}")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (userInputArray.length != 3) {
            throw new IllegalArgumentException("공은 3개만 입력할 수 있습니다.");
        }

        if (distinctCount(userInputArray) != 3) {
            throw new IllegalArgumentException("공은 중복 되지 않은 3개만 던질 수 있습니다.");
        }

        return userInputArray;

    }

    private static int[] userInputArray(String userInput) throws NumberFormatException {
        return Arrays.stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static long distinctCount(int[] userInput) {
        return Arrays.stream(userInput)
                .distinct()
                .count();
    }

    @Override
    public List<Ball> getBalls() {
        return balls.getBalls();
    }
}
