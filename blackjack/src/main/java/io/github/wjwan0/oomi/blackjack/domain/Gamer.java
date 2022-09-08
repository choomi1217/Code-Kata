package io.github.wjwan0.oomi.blackjack.domain;

import java.util.List;

public class Gamer {

    private final CardDeck cardDeck;
    private int bettingMoney = 0;

    private Gamer(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public static Gamer from(CardDeck cardDeck) {
        return new Gamer(cardDeck);
    }

    public void isWantDraw(Card card) {
        cardDeck.addCard(card);
    }

    public int sumCard() {
        return cardDeck.totalScore();
    }

    public List<Card> getCards() {
        return cardDeck.getAllCard();
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

