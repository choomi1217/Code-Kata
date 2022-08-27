import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        validation(lotto);
        this.lotto = new ArrayList<>(lotto);
    }

    public static Lotto from(List<LottoNumber> from) {
        return new Lotto(from);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(lotto);
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
}
