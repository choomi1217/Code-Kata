package io.github.wjwan0.oomi.blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardDeckTest {

    @Test
    @DisplayName("전체 카드덱 생성 테스트")
    void cardDeckContructorTest() {
        assertDoesNotThrow(CardDeck::from);
    }

    @Test
    @DisplayName("카드 52장 확인")
    void _52CardsCheck() {
        CardDeck cardDeck = CardDeck.from();
        assertEquals(cardDeck.allCard().size(), 52);
    }

    @Test
    void 카드뽑기() {
        CardDeck cardDeck = CardDeck.from();
        Card card = cardDeck.drawCard();
        assertEquals(cardDeck.allCard().size(), 51);
    }

    @Test
    void 싱글톤_테스트() {
        CardDeck cardDeck1 = CardDeck.from();
        CardDeck cardDeck2 = CardDeck.from();
        assertEquals(cardDeck1, cardDeck2);
    }
}
