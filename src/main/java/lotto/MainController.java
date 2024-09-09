package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Budget;
import lotto.view.InputView;

public class MainController {
    public static void run() {
        Budget budget = new Budget(InputView.readInteger("구입금액을 입력해 주세요."));
    }
}
