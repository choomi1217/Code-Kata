package io.github.wjwan0.oomi.blackjack.domain;

public class Dealer {

    private final CardPack cardPack;
    private final CardDeck cardDeck;

    private Dealer(CardPack cardPack, CardDeck cardDeck) {
        this.cardPack = cardPack;
        this.cardDeck = cardDeck;
    }

    public static Dealer from(CardPack cardPack, CardDeck cardDeck) {
        return new Dealer(cardPack, cardDeck);
    }

    public void drawCard(Gamer gamer) {
        gamer.isWantDraw(cardDeck.drawCard());
    }

    public void drawCard() {
        if (cardPack.totalScore() <= 16) {
            cardPack.addCard(cardDeck.drawCard());
        }
    }

    public int totalScore() {
        return cardPack.totalScore();
    }
}
