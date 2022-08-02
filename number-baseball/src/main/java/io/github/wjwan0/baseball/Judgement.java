package io.github.wjwan0.baseball;

public class Judgement {

    private final int ballCount;
    private final int strikeCount;

    //심판은 그냥 볼체크랑 스트라이크를 한번에 해주고 그거에 대한 카운트를 넘겨주면 된다.
    //굳이 컴퓨터가 ballcheck랑 stringcheck를 나눠서 할 필요가 없다.
    //무언가를 통해서 String computer, String user를 받으면 ballCheck, strikeCheck를 한번에 해주고
    //값을 리턴해준다.

    public Judgement(Numbers computer, Numbers user) {
        this.ballCount = setBallCount(computer.threeNumbers(), user.threeNumbers());
        this.strikeCount = setStrikeCount(computer.threeNumbers(), user.threeNumbers());
    }

    private int setBallCount(String computer, String user) {
        int isBall = (int) computer.chars()
                .mapToObj(computerChar -> user.contains(Character.toString(computerChar)))
                .filter(containBoolean -> containBoolean)
                .count();

        return isBall != 0 ? isBall - setStrikeCount(computer, user) : 4;
    }

    private int setStrikeCount(String computer, String user) {
        int isStrike = 0;
        for (int i = 0; i < computer.length(); i++) {
            isStrike = computer.charAt(i) == user.charAt(i) ? isStrike + 1 : isStrike;
        }
        return isStrike;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
