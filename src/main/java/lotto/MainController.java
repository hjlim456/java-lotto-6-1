package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class MainController {

    public static void run() {
        Budget budget = inputBudget();
        Lotto WinningLotto = readWinningLotto();
        //보너스 번호입력 구현하기

        Lottos purchasedLotto = buyLotto(budget);
    }

    private static Lotto readWinningLotto() {
        String input = Console.readLine();
        Validator.validateBlank(input);
        Validator.validateDeliiter(input);
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Validator::parseAndValidateNumber)
                .sorted()
                .toList();
        return new Lotto(winningNumbers);
    }

    private static Lottos buyLotto(Budget budget) {
        int lottoCount=budget.getAmount() / 1000;
        Lottos lottos = new Lottos(new ArrayList<>());

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private static Budget inputBudget() {
        Budget budget = null;
        while (budget == null) {
            try {
                budget = new Budget(InputView.readInteger("구입금액을 입력해 주세요."));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해 주세요.");
            }
        }
        return budget;
    }


}
