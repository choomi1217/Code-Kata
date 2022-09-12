package io.github.wjwan0.oomi.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

    private final List<Card> cards;

    private CardDeck(List<Card> cards){
        this.cards = new ArrayList<>(cards);
    }

    public static CardDeck from(List<Card> cardList) {
        return new CardDeck(cardList);
    }

    public int totalScore() {

        int sum = cards.stream()
                .filter(card -> card.trumpNumber().getScore() != 1)
                .mapToInt(card -> card.trumpNumber().getScore())
                .sum();

        int aceCount = (int) cards.stream()
                .filter(card -> card.trumpNumber().getScore() == 1)
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

        if (sum < 11) {
            return sum + (aceCount * 11);
        }

        return sum + aceCount;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> cardDeck() {
        return new ArrayList<>(cards);
    }
}
