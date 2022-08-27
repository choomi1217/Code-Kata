import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoCommitteeTests {

    @Test
    void 로또_위원회를_생성한다() {
//        LottoCommittee.from(
//                Lotto.from(List.of(
//                        LottoNumber.from(1),
//                        LottoNumber.from(2),
//                        LottoNumber.from(3),
//                        LottoNumber.from(4),
//                        LottoNumber.from(5),
//                        LottoNumber.from(6)
//                ))
//        );
        assertDoesNotThrow(() -> {
            LottoCommittee.from(() -> Lotto.from(List.of(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
            )));
        });
    }

    @Test
    void test() {
        LottoCommittee lottoCommittee = LottoCommittee.from(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        )));

        EnumMap<Rank, Integer> ranks = lottoCommittee.matches(
                List.of(
                        Lotto.from(List.of(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(4),
                                LottoNumber.from(5),
                                LottoNumber.from(6)
                        )),
                        Lotto.from(List.of(
                                LottoNumber.from(1),
                                LottoNumber.from(2),
                                LottoNumber.from(3),
                                LottoNumber.from(4),
                                LottoNumber.from(5),
                                LottoNumber.from(6)
                        ))
                )
        );
        assertThat(ranks.get(Rank.FIRST)).isEqualTo(2);
    }
}