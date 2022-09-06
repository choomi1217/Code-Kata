package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GamerTest {

    @Test
    void 게이머_생성_테스트() {
        assertDoesNotThrow(() -> Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        ))));
    }

    @Test
    void 카드_합_더하기_테스트() {
        Gamer gamer = Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));

        assertEquals(gamer.sumCard(), 21);
    }

    @Test
    void 카드_뽑기_테스트() {

        Gamer gamer = Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));

        gamer.isWantDraw(Card.of(Suit.CLOVER, TrumpNumber.ACE));

        assertEquals(gamer.getCards().size(), 3);
    }

    @Test
    void 배팅_여부_테스트() {
        Gamer gamer = Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));

        assertTrue(gamer.isBetting("y"));
    }

    @Test
    void 배팅_금액_테스트() {
        Gamer gamer = Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));

        gamer.bettingMoney(10_000);
        assertEquals(gamer.getMoney(), 10_000);
    }

    //    @Test
//    void 블랙잭_테스트() {
//        Card firstCard = Card.of(Suit.CLOVER, TrumpNumber.ACE);
//        Card secondCard = Card.of(Suit.SPADES, TrumpNumber.KING);
//
//        Gamer gamer = Gamer.from(new CardPack());
//        assertTrue();
//        gamer.checkBlackJack();
//    }

}
