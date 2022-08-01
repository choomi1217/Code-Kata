package io.github.wjwan0.baseball;

final class UserNumbers implements Numbers {
    private final String value;

    UserNumbers(String numbers) {
        if (numbers == null || numbers.isBlank() || numbers.contains(" ")) {
            throw new IllegalArgumentException();
        }
        if (numbers.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("must be non-duplicated three numbers");
        }

        this.value = numbers;
    }

    @Override
    public String threeNumbers() {
        return this.value;
    }
}
