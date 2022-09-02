package io.github.wjwan0.oomi.blackjack.domain;

import java.util.List;

public class Hits {
    public boolean isWantDraw(String answer) {
        return answer.equals("y");
    }

    /**
     * 1. ace 카드 개수 뽑기
     * 2. ace 제외한 거 총 합 구하기
     * 3. 거기서 ace가 2장 이상일 경우 첫번째만 11인지 1인지 판별 나머지는 다 1만 더하기
     * 총합 return
     */
    public int sumCard(List<Card> cardList) {

        int sum = cardList.stream()
                .filter(card -> card.getTrumpNumber().getScore() != 1)
                .mapToInt(card -> card.getTrumpNumber().getScore())
                .sum();

        int aceCount = (int) cardList.stream()
                .filter(card -> card.getTrumpNumber().getScore() == 1)
                .count();

        if (aceCount == 0) {
            return sum;
        }

        if (aceCount >= 2 && sum + aceCount - 1 <= 10) {
            return sum + aceCount - 1 + 11;
        }

        if (aceCount >= 2) {
            return sum + aceCount;
        }

        if(sum < 11){
            return sum + (aceCount * 11);
        }

        return sum + aceCount;
    }
}
