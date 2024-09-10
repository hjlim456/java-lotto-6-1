package lotto;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;

public class Validator {
    public static void validatePositiveNumber(String inputString) {
        if (Integer.parseInt(inputString)<=0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    public static void validateBlank(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
    }

    public static void validateType(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static void validateDeliiter(String input) {
        input.contains(",");
    }
    public static Integer parseAndValidateNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }
    }

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_LOTTO_RANGE.getMessage());
        }
    }

    public static int parseAndValidateBonusNumber(String input, Lotto winningLotto) {
        validateBlank(input);

        int bonusNumber = Validator.parseAndValidateNotNumber(input);
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATED_NUMBER_WITH_WINNINGNUMBERS.getMessage());
        }
        return bonusNumber;
    }

}
