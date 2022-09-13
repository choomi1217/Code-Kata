package io.github.wjwan0.oomi.blackjack.application;

import io.github.wjwan0.oomi.blackjack.application.in.ConsoleIn;
import io.github.wjwan0.oomi.blackjack.application.out.ConsoleOut;
import io.github.wjwan0.oomi.blackjack.domain.*;

import java.util.List;
import java.util.Objects;

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
        Dealer dealer = Dealer.of(dealerCardDeck, cardPack);
        return new BlackJack(dealer);
    }


    public void init() {
        consoleOut.inputGamersComment();
        String gamerNames = consoleIn.enterGamerName();


        Gamers gamers = null;
        try {
            gamers = Gamers.from(gamerNames, dealer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.init();
        }

        List<Gamer> gamerList = Objects.requireNonNull(gamers).gamerList();
        gamerList.forEach(gamer -> {
            consoleOut.inputBettingMoneyComment(gamer);
            gamer.bettingMoney(consoleIn.betting());
        });

        consoleOut.startGameComment(gamers);
        consoleOut.showDealerCards(dealer);
        gamerList.forEach(consoleOut::showGamerCards);

        gamerList.forEach(gamer -> {
            gamer.atStartBlackJack();
            moreCard(gamer);
        });

        while (16 >= dealer.totalScore()) {
            consoleOut.dealerMoreCardComment();
            dealer.drawCard();
        }

        consoleOut.resultDealerCards(dealer);
        gamerList.forEach(consoleOut::resultGamerCards);

        consoleOut.endGame(dealer, gamers);

    }

    //todo: 1depth 수정 필요
    private void moreCard(Gamer gamer) {
        while (true) {
            if (gamer.totalScore() > 21) {
                break;
            }
            if (gamer.totalScore() == 21) {
                consoleOut.blackJack();
                break;
            }
            consoleOut.gamerMoreCardComment(gamer);
            if (consoleIn.askMoreCard()) {
                dealer.drawCard(gamer);
                consoleOut.showGamerCards(gamer);
                continue;
            }
            break;
        }
    }
}
