package io.github.wjwan0.oomi.car.racing;

public class Car {
    private final String name;

    private int forwardState = 0;

    private final Move move;

    public Car(String name, Move move) {
        validation(name);
        this.move = move;
        this.name = name;
    }

    private void validation(String name) {
        if (name == null || name.isEmpty() || name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름을 정확하게 입력해 주세요.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하 입니다.");
        }
    }

    public void moveForwardCheck() {
        if (move.isItMove()) {
            forwardState++;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getForwardState() {
        return forwardState;
    }

    @Override
    public String toString() {
        return name + ": " + getForwardState();
    }
}
