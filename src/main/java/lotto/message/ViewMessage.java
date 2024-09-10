package lotto.message;

public enum ViewMessage {
    PURCHASED_COUNT_PRINT("개를 구매했습니다."),
    TOTAL_RETURN_RATE ("총 수익률은 %.1f%%입니다.%n");
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
