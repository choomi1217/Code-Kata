package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;

public class Card {

    private final Suit suit;
    private final TrumpNumber trumpNumber;

    private Card(Suit suit, TrumpNumber trumpNumber) {
        this.suit = suit;
        this.trumpNumber = trumpNumber;
    }

    public static Card of(Suit suit, TrumpNumber trumpNumber) {
        return new Card(suit, trumpNumber);
    }

    public Suit suit() {
        return suit;
    }

    public int trumpNumber() {
        return trumpNumber.getScore();
    }

    public String trumpName() {
        return trumpNumber.getName();
    }

}
