package domain;

import domain.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 로또_번호가_생성된다(int number) {
        assertDoesNotThrow(() -> LottoNumber.from(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또_번호가_범위를_벗어날_경우_예외가_발생한다(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 범위는 1~45여야 합니다.");
    }
}