import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {

    private final long salePrice;

    private LottoMachine(long salePrice) {
        this.salePrice = salePrice;
    }

    public static LottoMachine from(long price) {
        return new LottoMachine(price);
    }

    public List<Lotto> sell(long purchasePrice) {
        salePriceCheck(purchasePrice);
        long quantity = purchasePrice / salePrice;

        return LongStream.range(0, quantity)
                .mapToObj((__) -> Lotto.from(createRandomNumber(6)
                        .mapToObj(LottoNumber::from)
                        .collect(toList())))
                .collect(toList());
    }

    private void salePriceCheck(long purchasePrice) {
        if (salePrice > purchasePrice) {
            throw new IllegalArgumentException(String.format("최소 %d원이 지불되어야 합니다.", salePrice));
        }
    }

    private static IntStream createRandomNumber(int maxSize) {
        return RandomGenerator.getDefault()
                .ints(1, 46)
                .distinct()
                .limit(maxSize);
    }
}
