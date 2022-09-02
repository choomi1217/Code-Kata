package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private final ArrayDeque<Card> cardDeck;

    private CardDeck(ArrayDeque<Card> cardDeck) {
        this.cardDeck = new ArrayDeque<>(cardDeck);
    }

    public static CardDeck from() {
        List<Card> cardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (TrumpNumber number : TrumpNumber.values()) {
                cardDeck.add(Card.of(suit, number));
            }
        }
        shuffle(cardDeck);

        return new CardDeck(new ArrayDeque<>(cardDeck));
    }

    private static void shuffle(List<Card> cardDeck) {
        Collections.shuffle(cardDeck);
    }

    public ArrayDeque<Card> getCardDeck() {
        return new ArrayDeque<>(cardDeck);
    }
}
