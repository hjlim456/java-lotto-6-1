package lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    public static void run() {
        //게임 초기화
        Budget budget = InputView.inputBudget();
        Lotto winningLotto = InputView.createWinningLotto();
        int bonusNumber = InputView.createBonusNumber(winningLotto);
        //게임진행
        Lottos purchasedLottos = Lotto.buyLottoUsingBudget(budget);

        //GameEnd
        Map<String, Long> resultMap = new LinkedHashMap<>();
        Lottos.compareLottos(resultMap,purchasedLottos, winningLotto, bonusNumber);

        OutputView.printResult(resultMap);
        OutputView.calculateTotalReturnRate(budget,resultMap);
    }
}
