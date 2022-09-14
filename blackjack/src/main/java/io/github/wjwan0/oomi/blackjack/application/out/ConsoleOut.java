package io.github.wjwan0.oomi.blackjack.application.out;

import io.github.wjwan0.oomi.blackjack.domain.*;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;

public class ConsoleOut {
    public void inputGamersComment() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void inputBettingMoneyComment(Gamer gamer) {
        System.out.printf("%s의 배팅 금액은?", gamer.getGamerName());
    }

    public void startGameComment(Gamers gamers) {
        Queue<String> gamerNames = gamers.gamerList().stream()
                .map(Gamer::getGamerName)
                .collect(toCollection(LinkedList::new));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("딜러에게 1장\n");

        while (gamerNames.size() > 1) {
            stringBuilder.append(String.format("%s, ", gamerNames.poll()));
        }
        stringBuilder.append(String.format("%s 에게 2장의 카드를 나누었습니다.", gamerNames.poll()));

        System.out.println(stringBuilder);
    }

    public void showDealerCards(Dealer dealer) {
        Queue<Card> dealerCard = new LinkedList<>(dealer.cardDeck().cardDeck());
        StringBuilder result = new StringBuilder();
        result.append("딜러: ");

        cardFormatting(dealerCard, result);
        System.out.println(result);
    }

    public void showGamerCards(Gamer gamer) {
        Queue<Card> gamerCard = new LinkedList<>(gamer.cardDeck().cardDeck());
        StringBuilder result = new StringBuilder();
        String nameFormat = String.format("%s카드: ", gamer.getGamerName());

        result.append(nameFormat);

        cardFormatting(gamerCard, result);
        System.out.println(result);
    }

    public void resultDealerCards(Dealer dealer) {
        Queue<Card> dealerCard = new LinkedList<>(dealer.cardDeck().cardDeck());
        StringBuilder result = new StringBuilder();
        result.append("딜러: ");

        cardFormatting(dealerCard, result);
        getGameResult(dealer.cardDeck(), result);
    }

    public void resultGamerCards(Gamer gamer) {
        Queue<Card> gamerCard = new LinkedList<>(gamer.cardDeck().cardDeck());
        StringBuilder result = new StringBuilder();
        String nameFormat = String.format("%s카드: ", gamer.getGamerName());

        result.append(nameFormat);

        cardFormatting(gamerCard, result);
        getGameResult(gamer.cardDeck(), result);
    }

    public void gamerMoreCardComment(Gamer gamer) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", gamer.getGamerName());
    }

    public void dealerMoreCardComment() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void endGame(Dealer dealer, Gamers gamers) {
        System.out.println("## 최종 수익");
        System.out.println("딜러: " + dealer.getMoney());
        for (Gamer gamer : gamers.gamerList()) {
            System.out.printf("%s: %d%n", gamer.getGamerName(), gamer.getMoney());
        }
    }

    public void blackJack() {
        System.out.println("블랙잭 !");
    }

    private void getGameResult(CardDeck gamer, StringBuilder result) {
        int resultCardScore = gamer.totalScore();
        String content;
        content = String.format(" - 결과: %d", resultCardScore);
        if (resultCardScore > 21) {
            content = " - 결과: 사망";
        }
        result.append(content);
        System.out.println(result);
    }

    private void cardFormatting(Queue<Card> cardQueue, StringBuilder result) {
        while (cardQueue.size() > 1) {
            Card card = cardQueue.poll();
            result.append(String.format("%s", card.trumpName()));
            result.append(String.format("%s, ", card.suit().getSuit()));
        }
        Card card = cardQueue.poll();
        result.append(String.format("%s", card.trumpName()));
        result.append(card.suit().getSuit());
    }

}

