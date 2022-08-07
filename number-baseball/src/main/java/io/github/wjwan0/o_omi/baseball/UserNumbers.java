package io.github.wjwan0.o_omi.baseball;

final class UserNumbers implements Numbers {
    private final String value;

    UserNumbers(String numbers) {
        if (numbers == null || numbers.isBlank() || numbers.contains(" ")) {
            throw new IllegalArgumentException("*공백은* 입력할 수 없습니다.");
        }
        if (numbers.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("*중복 되지 않는* 3개의 숫자만 입력 가능 합니다.");
        }
        if (!numbers.matches("\\d{3}")) {
            throw new IllegalArgumentException("*숫자만* 입력할 수 있습니다.");
        }
        this.value = numbers;
    }

    @Override
    public String threeNumbers() {
        return this.value;
    }
}
