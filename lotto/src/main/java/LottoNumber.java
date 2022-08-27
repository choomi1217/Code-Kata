import java.util.Objects;

public class LottoNumber {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validation(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public int get() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    private void validation(int lottoNumber) {
        if (!(lottoNumber >= 1 && lottoNumber <= 45)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45여야 합니다.");
        }
    }
}
