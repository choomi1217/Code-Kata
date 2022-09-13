package io.github.wjwan0.oomi.blackjack.domain;

import io.github.wjwan0.oomi.blackjack.domain.trump.Suit;
import io.github.wjwan0.oomi.blackjack.domain.trump.TrumpNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GamersTest {

    Dealer dealer;

    @BeforeEach
    void init() {
        List<Card> cards = List.of(Card.of(Suit.DIAMONDS, TrumpNumber.ACE));
        CardDeck cardDeck = CardDeck.from(cards);
        this.dealer = Dealer.of(cardDeck, CardPack.from());
    }

    @Test
    void 생성_테스트() {
        //given
        List<Card> cards = List.of(Card.of(Suit.DIAMONDS, TrumpNumber.ACE));
        CardDeck cardDeck = CardDeck.from(cards);
        Dealer dealer = Dealer.of(cardDeck, CardPack.from());

        //then
        assertDoesNotThrow(() -> Gamers.from("wanjoo", dealer));
    }

    @Test
    void 이름이_빈값이면_예외가_발생한다() {
        assertThatCode(() -> Gamers.from("", dealer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자의 이름은 빈 값이 될 수 없습니다.");
    }
    @Test
    void 이름에_공백이_있으면_예외가_발생한다() {
        assertThatCode(() -> Gamers.from("wj, fw", dealer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자의 이름에 공백이 들어갈 수 없습니다.");
    }
}
