package io.github.wjwan0.oomi.blackjack.domain;

public class Gamer {

    private final CardDeck cardDeck;
    private int money = 0;
    private final String gamerName;

    private Gamer(CardDeck cardDeck, String gamerName) {
        this.cardDeck = cardDeck;
        this.gamerName = gamerName;
    }

    public static Gamer of(CardDeck cardDeck, String gamerName) {
        validation(gamerName);
        return new Gamer(cardDeck, gamerName);
    }

    private static void validation(String gamerName) {
        if (gamerName == null || gamerName.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
    }

    public String getGamerName() {
        return this.gamerName;
    }

    public void give(Card card) {
        cardDeck.addCard(card);
    }

    public int totalScore() {
        return cardDeck.totalScore();
    }

    public CardDeck gamerCardDeck() {
        return cardDeck;
    }

    public boolean isBetting(String answer) {
        return answer.equals("y");
    }

    public void bettingMoney(int inputMoney) {
        money = inputMoney;
    }

    public int getMoney() {
        return money;
    }

    public void atStartBlackJack() {
        if(cardDeck.totalScore()==21){
            money = (int) (money * 1.5);
        }
    }
}

