package io.github.wjwan0.oomi.blackjack.application;

import io.github.wjwan0.oomi.blackjack.application.in.ConsoleIn;
import io.github.wjwan0.oomi.blackjack.application.out.ConsoleOut;
import io.github.wjwan0.oomi.blackjack.domain.*;

import java.util.List;

public class BlackJack {
    private final ConsoleOut consoleOut = new ConsoleOut();
    private final ConsoleIn consoleIn = new ConsoleIn();
    private final Dealer dealer;


    private BlackJack(Dealer dealer) {
        this.dealer = dealer;
    }

    public static BlackJack from() {
        CardPack cardPack = CardPack.from();
        List<Card> cards = List.of(
                cardPack.drawCard()
        );
        CardDeck dealerCardDeck = CardDeck.from(cards);
        Dealer dealer = Dealer.from(dealerCardDeck, cardPack);
        return new BlackJack(dealer);
    }


    public void init() {
        consoleOut.inputGamersComment();
        String gamerNames = consoleIn.enterGamerName();

        Gamers gamers = Gamers.from(gamerNames, dealer);

        List<Gamer> gamerList = gamers.gamerList();
        gamerList.forEach(gamer -> {
            consoleOut.inputBettingMoneyComment(gamer);
            gamer.bettingMoney(consoleIn.betting());
        });

        consoleOut.startGameComment(gamers);
        consoleOut.showDealerCards(dealer);
        gamerList.forEach(consoleOut::showGamerCards);

        gamerList.forEach(this::moreCardGamer);

        while (16 >= dealer.totalScore()) {
            consoleOut.dealerMoreCardComment();
            dealer.drawCard();
        }

        consoleOut.resultDealerCards(dealer);
        gamerList.forEach(consoleOut::resultGamerCards);

        consoleOut.endGame(dealer, gamers);

    }

    private void moreCardGamer(Gamer gamer) {
        do {
            if (gamer.getCards().totalScore() > 21) {
                System.out.println("21을 초과하여 카드를 더 받을 수 없습니다.");
                break;
            }
            consoleOut.gamerMoreCardComment(gamer);
            if (gamer.drawCard(consoleIn.askMoreCard())) {
                dealer.drawCard(gamer);
                consoleOut.showGamerCards(gamer);
                continue;
            }
            break;
        } while (true);
    }
}
