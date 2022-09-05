package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {

    @Test
    void 딜러_생성_테스트() {
        assertDoesNotThrow(() -> Dealer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )), CardDeck.from()));
    }

    @Test
    void 카드_나눠주기_테스트() {
        //given
        Dealer dealer = Dealer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )), CardDeck.from());
        Gamer gamer = Gamer.from(CardPack.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )));

        //when
        dealer.drawCard(gamer);

        //then
        assertEquals(gamer.getCards().size(), 3);
    }

    @Test
    void 딜러가_카드_4일_때_받기_테스트() {
        //given
        List<Card> cards = List.of(
                Card.of(Suit.CLOVER, TrumpNumber.TWO),
                Card.of(Suit.SPADES, TrumpNumber.TWO));
        CardPack cardPack = CardPack.from(cards);

        Dealer dealer = Dealer.from(cardPack, CardDeck.from());

        //when
        dealer.drawCard();

        //then
        assertNotEquals(dealer.totalScore(), 4);
    }

    @Test
    void 딜러가_카드_16일_때_더_받기_테스트() {
        //given
        List<Card> cards = List.of(
                Card.of(Suit.SPADES, TrumpNumber.NINE),
                Card.of(Suit.SPADES, TrumpNumber.SEVEN));
        CardPack cardPack = CardPack.from(cards);
        Dealer dealer = Dealer.from(cardPack, CardDeck.from());

        //when
        dealer.drawCard();

        //then
        assertNotEquals(dealer.totalScore(), 16);
    }

    @Test
    void 딜러가_카드_17일_때_더_안받기_테스트() {
        //given
        List<Card> cards = List.of(
                Card.of(Suit.SPADES, TrumpNumber.KING),
                Card.of(Suit.SPADES, TrumpNumber.SEVEN));
        CardPack cardPack = CardPack.from(cards);
        Dealer dealer = Dealer.from(cardPack, CardDeck.from());

        //when
        dealer.drawCard();

        //then
        assertEquals(dealer.totalScore(), 17);
    }

    @Test
    void 딜러가_카드_21일_때_더_안받기_테스트() {
        //given
        List<Card> cards = List.of(
                Card.of(Suit.SPADES, TrumpNumber.KING),
                Card.of(Suit.SPADES, TrumpNumber.ACE));
        CardPack cardPack = CardPack.from(cards);
        Dealer dealer = Dealer.from(cardPack, CardDeck.from());

        //when
        dealer.drawCard();

        //then
        assertEquals(dealer.totalScore(), 21);
    }
}
