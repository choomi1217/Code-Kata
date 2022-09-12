package io.github.wjwan0.oomi.blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Gamers(
        List<Gamer> gamerList
) {
    public static Gamers from(String gamerNames, Dealer dealer) {

        List<Gamer> gamers = Arrays.stream(gamerNames.split(","))
                .map(name -> {
                    List<Card> startCard = List.of(
                            dealer.getCardPack().drawCard(),
                            dealer.getCardPack().drawCard()
                    );
                    CardDeck gamerCardDeck = CardDeck.from(startCard);
                    return Gamer.of(gamerCardDeck, name);
                })
                .collect(Collectors.toList());
        return new Gamers(gamers);
    }

    @Override
    public List<Gamer> gamerList() {
        return new ArrayList<>(gamerList);
    }
}
