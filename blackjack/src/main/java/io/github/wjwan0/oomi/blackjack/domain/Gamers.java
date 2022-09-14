package io.github.wjwan0.oomi.blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Gamers(
        List<Gamer> gamerList
) {
    public static Gamers from(String gamerNames, Dealer dealer) {

        validation(gamerNames);

        List<Gamer> gamers = Arrays.stream(gamerNames.split(","))
                .map(name -> {
                    List<Card> startCard = List.of(
                            dealer.drawGamerCard(),
                            dealer.drawGamerCard()
                    );
                    CardDeck gamerCardDeck = CardDeck.from(startCard);
                    return Gamer.of(gamerCardDeck, name);
                })
                .collect(Collectors.toList());

        return new Gamers(gamers);
    }

    private static void validation(String gamerNames) {
        if (gamerNames.isEmpty()) {
            throw new IllegalArgumentException("사용자의 이름은 빈 값이 될 수 없습니다.");
        }
        if (gamerNames.contains(" ")) {
            throw new IllegalArgumentException("사용자의 이름에 공백이 들어갈 수 없습니다.");
        }
    }

    @Override
    public List<Gamer> gamerList() {
        return new ArrayList<>(gamerList);
    }
}
