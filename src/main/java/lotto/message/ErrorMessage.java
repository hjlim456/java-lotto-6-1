package lotto.message;

public enum ErrorMessage {
    PURCHASED_COUNT_PRINT("개를 구매했습니다."),
    INPUT_NOT_NUMBER("숫자가 아닌 값을 입력하셨습니다."),
    INPUT_NOT_LOTTO_RANGE("번호는 1부터 45까지의 숫자여야 합니다."),
    INPUT_DUPLICATED_NUMBER_WITH_WINNINGNUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시입력해주세요."),
    INPUT_BLANK("빈 값을 입력하셨습니다. 값을 입력해주세요."),
    INPUT_NOT_POSITIVE_NUMBER("0또는 음수는 입력할수없습니다. 양수를 입력해주세요");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return "[ERROR]" + message;
    }
}
