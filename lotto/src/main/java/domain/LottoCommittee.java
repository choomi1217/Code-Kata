package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.frequency;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class LottoCommittee {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    private LottoCommittee(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static LottoCommittee of(LottoGenerator generator, LottoNumber bonusBall) {
        Lotto lotto = generator.generate();
        if (lotto.hasNumber(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
        return new LottoCommittee(lotto, bonusBall);
    }

    public EnumMap<Rank, Integer> matches(List<Lotto> buyLottos) {
        return new EnumMap<>(getRankMap(buyLottos.stream()
                .map(lotto -> Rank.valueOf(lotto.matchCount(winningLotto), lotto.hasNumber(bonusBall)))
                .toList()));
    }

    private Map<Rank, Integer> getRankMap(List<Rank> ranks) {
        return Rank.stream()
                .collect(toMap(
                        identity(),
                        rank -> frequency(ranks, rank)
                ));
    }
}
