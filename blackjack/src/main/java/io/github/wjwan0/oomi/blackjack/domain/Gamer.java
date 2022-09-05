package io.github.wjwan0.oomi.blackjack.domain;

import java.util.List;

public class Gamer {

    private final CardPack cardPack;
    private int bettingMoney = 0;

    private Gamer(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public static Gamer from(CardPack cardPack) {
        return new Gamer(cardPack);
    }

    public void isWantDraw(Card card) {
        cardPack.addCard(card);
    }

    public int sumCard() {
        return cardPack.totalScore();
    }

    public List<Card> getCards() {
        return cardPack.getAllCard();
    }

    public boolean isBetting(String answer) {
        return answer.equals("y");
    }

    public void bettingMoney(int inputMoney) {
        bettingMoney = inputMoney;
    }

    public int getMoney() {
        return bettingMoney;
    }

    public boolean isWantDraw(String answer) {
        return answer.equals("y");
    }
}

