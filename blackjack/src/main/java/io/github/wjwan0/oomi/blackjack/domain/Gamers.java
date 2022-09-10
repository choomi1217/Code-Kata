package io.github.wjwan0.oomi.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public record Gamers(
        List<Gamer> gamerList
) {
    public static Gamers from(List<Gamer> gamerList) {
        return new Gamers(gamerList);
    }

    @Override
    public List<Gamer> gamerList() {
        return new ArrayList<>(gamerList);
    }
}
