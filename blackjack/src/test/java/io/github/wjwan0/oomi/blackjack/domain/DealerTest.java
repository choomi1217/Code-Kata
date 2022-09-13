package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {

    @Test
    void 딜러_생성_테스트() {
        assertDoesNotThrow(() -> Dealer.of(CardDeck.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )), CardPack.from()));
    }

    @Test
    void 카드_나눠주기_테스트() {
        //given
        Dealer dealer = Dealer.of(CardDeck.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )), CardPack.from());
        Gamer gamer = Gamer.of(CardDeck.from(List.of(
                Card.of(Suit.SPADES, TrumpNumber.ACE),
                Card.of(Suit.SPADES, TrumpNumber.KING)
        )),"name");

        //when
        dealer.drawCard(gamer);

        //then
        assertEquals(gamer.cardDeck().cardDeck(), 3);
    }

    @Test
    void 딜러가_카드_4일_때_받기_테스트() {
        //given
        List<Card> cards = List.of(
                Card.of(Suit.CLOVER, TrumpNumber.TWO),
                Card.of(Suit.SPADES, TrumpNumber.TWO));
        CardDeck cardDeck = CardDeck.from(cards);

        Dealer dealer = Dealer.of(cardDeck, CardPack.from());

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
        CardDeck cardDeck = CardDeck.from(cards);
        Dealer dealer = Dealer.of(cardDeck, CardPack.from());

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
        CardDeck cardDeck = CardDeck.from(cards);
        Dealer dealer = Dealer.of(cardDeck, CardPack.from());

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
        CardDeck cardDeck = CardDeck.from(cards);
        Dealer dealer = Dealer.of(cardDeck, CardPack.from());

        //when
        dealer.drawCard();

        //then
        assertEquals(dealer.totalScore(), 21);
    }
}
