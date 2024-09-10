package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import lotto.Validator;
import lotto.domain.Budget;
import lotto.domain.Lotto;

public class InputView {
    public static int readInteger(String message) {
        while (true) {
            System.out.println(message);
            String inputString = Console.readLine();
            Integer reslt = attemptToParseInteger(inputString);
            if (reslt != null) {
                return reslt;
            }
        }
    }

    private static Integer attemptToParseInteger(String inputString) {
        try {
            Validator.validateBlank(inputString);
            Validator.validateType(inputString);
            Validator.validatePositiveNumber(inputString);
            return Integer.parseInt(inputString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Budget inputBudget() {
        Budget budget = null;
        while (budget == null) {
            budget = attemptToInputBudget();
        }
        return budget;
    }

    private static Budget attemptToInputBudget() {
        try {
            return new Budget(InputView.readInteger("구입금액을 입력해 주세요."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " 다시 입력해 주세요.");
            return null;
        }
    }

    public static Lotto createWinningLotto() {
        System.out.println("로또 번호 6자리를 입력해주세요");
        String input = Console.readLine();
        Validator.validateBlank(input);
        Validator.validateDeliiter(input);
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Validator::parseAndValidateNotNumber)
                .sorted()
                .toList();
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("로또번호는 6개를 입니다. 입력 갯수를 확인하세요");
        }

        return new Lotto(winningNumbers);
    }
    public static int createBonusNumber(Lotto winningLotto) {
        while (true) {
            System.out.println("보너스 숫자를 입력해주세요");
            String input = Console.readLine();
            int bonusNumber = parseBounusNumber(input, winningLotto);
            if (bonusNumber != -1) {
                return bonusNumber;
            }
        }
    }
    private static int parseBounusNumber(String input, Lotto winningLotto) {
        try{
            return Validator.parseAndValidateBonusNumber(input, winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
