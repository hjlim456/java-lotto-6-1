package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class MainController {

    public static void run() {
        Budget budget = inputBudget();

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
