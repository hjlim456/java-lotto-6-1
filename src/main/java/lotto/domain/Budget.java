package lotto.domain;

import lotto.view.InputView;

public class Budget {
    private int amount;

    public Budget(int amount) {
        validateBudget(amount);
        this.amount = amount;
    }
    private static void validateBudget(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로만 금액을 입력해주세요.");
        }
    }
    public int getAmount() {
        return amount;
    }
}
