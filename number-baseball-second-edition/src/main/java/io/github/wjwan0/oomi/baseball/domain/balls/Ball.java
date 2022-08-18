package io.github.wjwan0.oomi.baseball.domain.balls;

public record Ball(int number) {
    // 생성자, Getter, Hashcode, equals

    public Ball {
        ballValidationCheck(number);
    }

    //구현만
    private void ballValidationCheck(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(" 양수 값만 입력 해주세요. ");
        }
    }
}
