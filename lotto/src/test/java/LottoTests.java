import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTests {
    @Test
    void 로또가_생성된다() {
        assertDoesNotThrow(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        )));
    }

    @Test
    void 로또_번호가_중복될_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(1),
                LottoNumber.from(1),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        ))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또_번호가_6개가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5)
        ))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개가 되어야 합니다.");
    }
}
