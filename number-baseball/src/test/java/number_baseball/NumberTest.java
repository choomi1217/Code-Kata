package number_baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void 중복되는_숫자가_있으면_예외처리를_한다() {
        assertThatThrownBy(() -> Numbers.of("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"12", "1234", "12 "})
    void mustBe3Numbers(String testcase) {
        assertThatThrownBy(() -> Numbers.of(testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되지않는_숫자_세자리가_들어갔을_경우_예외를_발생하지_않는다() {
        assertThatCode(() -> Numbers.of("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void HastSET_중복제거_테스트() {
        Set<Integer> set = new HashSet<>();
        
        set.add(1);
        set.add(1);
        set.add(2);

        Assertions.assertThat(set.size()).isEqualTo(2);
    }
}

