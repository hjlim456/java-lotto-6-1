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
        Lotto winningLotto = createWinningLotto();
        int bonusNumber = createBonusNumber(winningLotto);

        Lottos purchasedLotto = buyLotto(budget);

        System.out.println(purchasedLotto.printAllLottoNumbers());
    }

    private static int createBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println("보너스 숫자를 입력해주세요");
                String input = Console.readLine();
                int bonusNumber = Validator.parseAndValidateBonusNumber(input, winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private static Lotto createWinningLotto() {
        System.out.println("로또 번호 6자리를 입력해주세요");
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
        System.out.println(lottoCount + "개를 구매했습니다.");
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
