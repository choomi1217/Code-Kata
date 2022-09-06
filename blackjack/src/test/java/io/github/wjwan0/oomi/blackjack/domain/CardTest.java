package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @ParameterizedTest
    @MethodSource("cardConstructorTest")
    @DisplayName("카드 생성 테스트")
    void cardContructorTest(Suit suit, TrumpNumber trumpNumber) {
        assertDoesNotThrow(() -> Card.of(suit, trumpNumber));
    }

    @Test
    @DisplayName("카드 get 테스트")
    void getCardTest() {
        Card card = Card.of(Suit.CLOVER, TrumpNumber.ACE);
        assertEquals(card.getTrumpNumber(), TrumpNumber.ACE);
    }

    public static Stream<Arguments> cardConstructorTest(){
        return Stream.of(
                Arguments.of(Suit.CLOVER, TrumpNumber.ACE),
                Arguments.of(Suit.SPADES, TrumpNumber.TWO),
                Arguments.of(Suit.HEART, TrumpNumber.THREE),
                Arguments.of(Suit.DIAMONDS, TrumpNumber.FOUR)
        );
    }

}
