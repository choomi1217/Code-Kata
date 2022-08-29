package application.out;

import domain.Lotto;
import domain.LottoNumber;
import domain.Rank;

import java.util.EnumMap;
import java.util.stream.Collectors;

public class ConsoleOut {

    public void buyLotto() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public void boughtLotto(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public void printLotto(Lotto lotto) {
        String buyNumbers = lotto.getNumbers()
                .stream()
                .map(LottoNumber::get)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[%s]\n", buyNumbers);
    }

    public void inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void statistics(EnumMap<Rank, Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        printStatistics(3, Rank.FIFTH, ranks.get(Rank.FIFTH));
        printStatistics(4, Rank.FOURTH, ranks.get(Rank.FOURTH));
        printStatistics(5, Rank.THIRD, ranks.get(Rank.THIRD));
        printStatistics(5, Rank.SECOND, ranks.get(Rank.SECOND));
        printStatistics(6, Rank.FIRST, ranks.get(Rank.FIRST));
    }
    private void printStatistics(int matchCount, Rank rank, int lottoCounts) {
        System.out.printf("%d개 일치 (%d원)-%d개\n", matchCount, rank.getReward(), lottoCounts);
    }
    public void printYield(double yield) {
        System.out.printf("총 수익률은 %f입니다.", yield);
    }


}
