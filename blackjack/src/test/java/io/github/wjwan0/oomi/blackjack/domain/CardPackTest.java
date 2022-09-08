package io.github.wjwan0.oomi.blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardPackTest {

    @Test
    @DisplayName("전체 카드덱 생성 테스트")
    void cardDeckContructorTest() {
        assertDoesNotThrow(CardPack::from);
    }

    @Test
    @DisplayName("카드 52장 확인")
    void _52CardsCheck() {
        CardPack cardPack = CardPack.from();
        assertEquals(cardPack.allCard().size(), 52);
    }

    @Test
    void 카드뽑기() {
        CardPack cardPack = CardPack.from();
        Card card = cardPack.drawCard();
        assertEquals(cardPack.allCard().size(), 51);
    }

    @Test
    void 싱글톤_테스트() {
        CardPack cardDeck21 = CardPack.from();
        CardPack cardPack = CardPack.from();
        assertEquals(cardDeck21, cardPack);
    }
}
