package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardDeckTest {

    @Test
    void CardManager_생성_테스트() {
        assertDoesNotThrow(() -> CardDeck.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));
    }

    @ParameterizedTest
    @MethodSource("현재_카드_총_합")
    void 현재_카드_총_합_테스트(List<Card> cardList, int score) {
        CardDeck cardDeck = CardDeck.from(cardList);
        int sum = cardDeck.totalScore();
        assertEquals(sum, score);
    }

    @Test
    void 카드_추가_테스트() {
        CardDeck cardDeck = CardDeck.from(List.of(
                Card.of(Suit.CLOVER, TrumpNumber.THREE),
                Card.of(Suit.CLOVER, TrumpNumber.FOUR)
        ));

        cardDeck.addCard(Card.of(Suit.DIAMONDS, TrumpNumber.ACE));

        assertEquals(cardDeck.getAllCard().size(), 3);

    }

    private static Stream<Arguments> 현재_카드_총_합() {
        return Stream.of(
                Arguments.of(List.of(Card.of(Suit.CLOVER, TrumpNumber.THREE),
                        Card.of(Suit.CLOVER, TrumpNumber.FOUR),
                        Card.of(Suit.CLOVER, TrumpNumber.FIVE),
                        Card.of(Suit.CLOVER, TrumpNumber.SIX)), 18),
                Arguments.of(List.of(
                        Card.of(Suit.SPADES, TrumpNumber.THREE),
                        Card.of(Suit.SPADES, TrumpNumber.ACE),
                        Card.of(Suit.HEART, TrumpNumber.ACE),
                        Card.of(Suit.DIAMONDS, TrumpNumber.SEVEN)), 12),
                Arguments.of(List.of(
                        Card.of(Suit.SPADES, TrumpNumber.KING),
                        Card.of(Suit.SPADES, TrumpNumber.ACE)), 21),
                Arguments.of(List.of(
                        Card.of(Suit.SPADES, TrumpNumber.KING),
                        Card.of(Suit.SPADES, TrumpNumber.ACE),
                        Card.of(Suit.SPADES, TrumpNumber.ACE)), 12),
                Arguments.of(List.of(
                        Card.of(Suit.SPADES, TrumpNumber.KING),
                        Card.of(Suit.SPADES, TrumpNumber.QUEEN),
                        Card.of(Suit.SPADES, TrumpNumber.TEN)), 30),
                Arguments.of(List.of(
                        Card.of(Suit.SPADES, TrumpNumber.KING),
                        Card.of(Suit.SPADES, TrumpNumber.QUEEN),
                        Card.of(Suit.SPADES, TrumpNumber.ACE)), 21)
        );
    }


}