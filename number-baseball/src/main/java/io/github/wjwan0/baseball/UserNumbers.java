package io.github.wjwan0.baseball;

final class UserNumbers implements Numbers {
    private final String value;

    UserNumbers(String numbers) {
        if (numbers == null || numbers.isBlank() || numbers.contains(" ")) {
            throw new IllegalArgumentException("*공백은* 입력할 수 없습니다.");
        }
        if (numbers.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("*중복되지않는* 3개의 숫자만 입력 가능합니다.");
        }

        this.value = numbers;
    }

    @Override
    public String threeNumbers() {
        return this.value;
    }
}
