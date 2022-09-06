package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> lotto) {
        validation(lotto);
        this.numbers = new ArrayList<>(lotto);
    }

    public static Lotto from(List<LottoNumber> from) {
        return new Lotto(from);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validation(List<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개가 되어야 합니다.");
        }
        long count = lottoNumber.stream()
                .distinct()
                .count();
        if (count != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
