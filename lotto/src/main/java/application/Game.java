package application;

import application.in.ConsoleIn;
import application.out.ConsoleOut;
import domain.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Game {
    private final ConsoleIn consoleIn = new ConsoleIn();
    private final ConsoleOut consoleOut = new ConsoleOut();


    public void init() {
        consoleOut.buyLotto();
        LottoMachine lottoMachine = LottoMachine.from(1000);
        long inputMoney = consoleIn.inputMoney();
        List<Lotto> buyLottos = lottoMachine.sell(inputMoney);
        consoleOut.boughtLotto(buyLottos.size());
        buyLottos.forEach(consoleOut::printLotto);
        consoleOut.inputWinningNumber();

        String winningNumber = consoleIn.inputWinningNumbers();
        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::from)
                .toList();

        consoleOut.inputBonusBall();
        LottoNumber bonusBall = LottoNumber.from(consoleIn.inputBonusBall());

        LottoCommittee lottoCommittee = LottoCommittee.of(() -> Lotto.from(lottoNumbers), bonusBall);

        EnumMap<Rank, Integer> matchLotto = lottoCommittee.matches(buyLottos);
        consoleOut.statistics(matchLotto);

        double totalMoney = Rank.totalMoney(matchLotto);

        consoleOut.printYield(totalMoney / inputMoney);
        consoleIn.close();
    }
}
