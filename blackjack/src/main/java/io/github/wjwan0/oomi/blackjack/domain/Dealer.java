package io.github.wjwan0.oomi.blackjack.domain;

public class Dealer {

    private final CardDeck cardDeck;
    private final CardPack cardPack;

    private Dealer(CardDeck cardDeck, CardPack cardPack) {
        this.cardDeck = cardDeck;
        this.cardPack = cardPack;
    }

    public static Dealer from(CardDeck cardDeck, CardPack cardPack) {
        return new Dealer(cardDeck, cardPack);
    }

    public void drawCard(Gamer gamer) {
        gamer.drawCard(cardPack.drawCard());
    }

    public void drawCard() {
        if (cardDeck.totalScore() <= 16) {
            cardDeck.addCard(cardPack.drawCard());
        }
    }

    public int totalScore() {
        return cardDeck.totalScore();
    }

    public CardDeck cardDeck() {
        return cardDeck;
    }
}
