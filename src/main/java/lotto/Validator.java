package lotto;

import lotto.domain.Lotto;

public class Validator {
    public static void validatePositiveNumber(String inputString) {
        if (Integer.parseInt(inputString)<=0){
            throw new IllegalArgumentException("0또는 음수는 입력할수없습니다. 양수를 입력해주세요");
        }
    }

    public static void validateBlank(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력하셨습니다. 값을 입력해주세요.");
        }
    }

    public static void validateType(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력하셨습니다. 숫자를 입력해주세요.");
        }
    }

    public static void validateDeliiter(String input) {
        input.contains(",");
    }
    public static Integer parseAndValidateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    public static int parseAndValidateBonusNumber(String input, Lotto winningLotto) {
        validateBlank(input);

        int bonusNumber = Validator.parseAndValidateNumber(input);
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시입력해주세요.");
        }
        return bonusNumber;
    }

}
