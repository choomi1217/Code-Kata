package io.github.wjwan0.oomi.blackjack.domain.trump;

import java.util.stream.Stream;

public enum Suit {
    SPADES, CLOVER, HEART, DIAMONDS;

    public static Stream<Suit> of() {
        return Stream.of(
                Suit.values()
        );
    }
}
