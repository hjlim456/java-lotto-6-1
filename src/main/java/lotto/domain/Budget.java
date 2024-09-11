package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.message.ViewMessage;
import lotto.view.InputView;

public class Budget {
    private int amount;

    public Budget(int amount) {
        validateBudget(amount);
        this.amount = amount;
    }
    public static double calculateTotalReturnRate(Budget budget, Map<String, Long> resultMap) {
        // 당첨금액과 상금을 맵으로 정의
        Map<String, Long> prizeMap = new HashMap<>();
        prizeMap.put("3개 일치 (5,000원) - ", 5000L);
        prizeMap.put("4개 일치 (50,000원) - ", 50000L);
        prizeMap.put("5개 일치 (1,500,000원) - ", 1500000L);
        prizeMap.put("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000L);
        prizeMap.put("6개 일치 (2,000,000,000원) - ", 2000000000L);

        // 당첨 금액 계산
        long totalPrize = resultMap.entrySet().stream()
                .mapToLong(entry -> prizeMap.getOrDefault(entry.getKey(), 0L) * entry.getValue())
                .sum();

        // 총 투자 금액 계산
        long totalInvestment = budget.getAmount();

        // 수익률 계산
        return (double) totalPrize / totalInvestment * 100;

        // 결과 출력
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
