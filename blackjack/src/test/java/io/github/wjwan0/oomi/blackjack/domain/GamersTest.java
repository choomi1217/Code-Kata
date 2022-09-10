package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GamersTest {
    @Test
    void 생성_테스트() {
        //given
        List<Card> cards = List.of(Card.of(Suit.DIAMONDS, TrumpNumber.ACE));
        CardDeck cardDeck = CardDeck.from(cards);
        List<Gamer> gamers = List.of(Gamer.of(cardDeck, "name"));

        //then
        Assertions.assertDoesNotThrow(() -> Gamers.from(gamers));
    }


}
