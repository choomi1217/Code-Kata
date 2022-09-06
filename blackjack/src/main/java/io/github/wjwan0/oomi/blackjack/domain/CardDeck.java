package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;

import java.util.*;

public class CardDeck {

    private static CardDeck deck = null;

    private final ArrayDeque<Card> cardDeck;

    private CardDeck(ArrayDeque<Card> cardDeck) {
        this.cardDeck = new ArrayDeque<>(cardDeck);
    }

    public static CardDeck from() {
        if (deck == null) {
            deck = new CardDeck(new ArrayDeque<>(makeCardDeck()));
        }
        return deck;
    }

    private static List<Card> makeCardDeck() {
        List<Card> cardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (TrumpNumber number : TrumpNumber.values()) {
                cardDeck.add(Card.of(suit, number));
            }
        }
        shuffle(cardDeck);
        return cardDeck;
    }

    private static void shuffle(List<Card> cardDeck) {
        Collections.shuffle(cardDeck);
    }

    public ArrayDeque<Card> allCard() {
        return new ArrayDeque<>(cardDeck);
    }

    public Card drawCard() {
        return cardDeck.poll();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDeck cardDeck1 = (CardDeck) o;
        return Objects.equals(cardDeck, cardDeck1.cardDeck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardDeck);
    }
}
