package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

public class InputView {
    public static int readInteger(String message) {
        while (true) {
            System.out.println(message);
            String inputString = Console.readLine();
            try {
                Validator.validateBlank(inputString);
                Validator.validateType(inputString);
                Validator.validatePositiveNumber(inputString);
                return Integer.parseInt(inputString);
            } catch (IllegalArgumentException e) {
                System.out.println("[Error]"+ e.getMessage());
            }
        }
    }


}
