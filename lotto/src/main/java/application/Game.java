package application;

import application.in.ConsoleIn;
import application.out.ConsoleOut;
import domain.Lotto;
import domain.LottoCommittee;
import domain.LottoMachine;
import domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

public class Game {
    private final ConsoleIn consoleIn = new ConsoleIn();
    private final ConsoleOut consoleOut = new ConsoleOut();


    public void init() {
        consoleOut.buyLotto();
        LottoMachine lottoMachine = LottoMachine.from(1000);
        List<Lotto> buyLottos = lottoMachine.sell(consoleIn.inputMoney());
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

        consoleOut.statistics(lottoCommittee.matches(buyLottos));


    }
}
