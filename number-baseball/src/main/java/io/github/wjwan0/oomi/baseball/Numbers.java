package io.github.wjwan0.oomi.baseball;

public interface Numbers {
    /**
     * 어떻게 구현해라
     * 팩토리(?)
     * @return
     */
    String threeNumbers();

    static Numbers randomNumbers() {
        return new RandomNumbers();
    }

    static Numbers specificNumbers(String numbers) {
        return new UserNumbers(numbers);
    }
}