import domain.Lotto;
import domain.LottoCommittee;
import domain.LottoNumber;
import domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoCommitteeTests {

    @Test
    void 로또_위원회를_생성한다() {
        assertDoesNotThrow(() -> {
            LottoCommittee.of(() -> Lotto.from(List.of(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
            )), LottoNumber.from(43));
        });
    }

    @ParameterizedTest
    @MethodSource("matchCountProvider")
    void 당첨_확인_보너스볼_포함(List<Integer> lottoNumbers, Rank expectedRank, int expectedCount) {
        LottoCommittee lottoCommittee = LottoCommittee.of(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        )), LottoNumber.from(7));

        EnumMap<Rank, Integer> ranks = lottoCommittee.matches(
                List.of(
                        Lotto.from(
                                lottoNumbers.stream()
                                        .map(LottoNumber::from)
                                        .toList()
                        )
                )
        );
        assertThat(ranks.get(expectedRank)).isEqualTo(expectedCount);
    }

    public static Stream<Arguments> matchCountProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Rank.SECOND, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Rank.FIRST, 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 34), Rank.THIRD, 1)
        );
    }

    @Test
    void 보너스_볼_중복() {
        assertThatThrownBy(() -> LottoCommittee.of(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        )), LottoNumber.from(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
    }
}