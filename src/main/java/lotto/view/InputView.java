package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class InputView {
    public static int readInteger(String message) {
        while (true) {
            System.out.println(message);
            String inputString = Console.readLine();
            try {
                validateBlank(inputString);
                validateNumber(inputString);
                return Integer.parseInt(inputString);
            } catch (IllegalArgumentException e) {
                System.out.println("[Error]"+ e.getMessage());
            }
        }
    }

    private static void validateBlank(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하셨습니다. 값을 입력해주세요.");
        }
    }

    private static void validateNumber(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자를 입력하셨습니다. 숫자를 입력해주세요.");
        }
    }
}
