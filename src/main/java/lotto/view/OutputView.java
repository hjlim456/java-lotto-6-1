package lotto.view;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.message.ViewMessage;

public class OutputView {
    public static void printBuyResult(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + ViewMessage.PURCHASED_COUNT_PRINT.getMessage());
        System.out.println(lottos.printAllLottoNumbers());
    }
    public static void printResult(Map<String, Long> resultMap) {
        resultMap.forEach((key, value) ->{
            System.out.println(key + value + "개");
                }
        );
    }

    public static void calculateTotalReturnRate(Budget budget, Map<String, Long> resultMap) {
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
        double returnRate = (double) totalPrize / totalInvestment * 100;

        // 결과 출력
        System.out.printf(ViewMessage.TOTAL_RETURN_RATE.getMessage(), returnRate);
    }



}
