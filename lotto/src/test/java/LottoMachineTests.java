import domain.Lotto;
import domain.LottoMachine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoMachineTests {

    @Test
    void 로또_머신이_생성된다() {
        assertDoesNotThrow(() -> LottoMachine.from(1_000));
    }

    @Test
    void 로또를_발급한다() {
        LottoMachine machine = LottoMachine.from(1_000);

        List<Lotto> lottos = machine.sell(1_000);
        assertThat(lottos).hasSize(1);
    }

    @Test
    void 로또_한장_가격_이하일_경우_예외가_발생한다() {
        int price = 1_000;
        LottoMachine machine = LottoMachine.from(price);

        assertThatThrownBy(() -> machine.sell(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("최소 %d원이 지불되어야 합니다.", price));
    }
}