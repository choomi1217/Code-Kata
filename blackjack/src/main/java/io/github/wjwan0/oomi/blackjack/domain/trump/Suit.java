package io.github.wjwan0.oomi.blackjack.domain.trump;

import java.util.stream.Stream;

public enum Suit {
    SPADES("스페이드"), CLOVER("클로버"), HEART("하트"), DIAMONDS("다이아몬드");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public static Stream<Suit> of() {
        return Stream.of(
                Suit.values()
        );
    }

    public String getSuit() {
        return suit;
    }
}
