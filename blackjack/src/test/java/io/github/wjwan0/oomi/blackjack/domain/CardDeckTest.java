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
        CardDeck cardDeck = CardDeck.from();
        assertEquals(cardDeck.getCardDeck().size(), 52);
    }


}
