package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
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
        Lottos purchasedLottos = OutputView.buyLotto(budget);
        System.out.println(purchasedLottos.printAllLottoNumbers());

        //GameEnd
        Map<String, Long> resultMap = new LinkedHashMap<>();
        Lottos.compareLottos(resultMap,purchasedLottos, winningLotto, bonusNumber);

        OutputView.printResult(resultMap);
        OutputView.calculateTotalReturnRate(budget,resultMap);
    }
}
