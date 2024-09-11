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
    public static void printInvestmentRate(double calculateTotalReturnRate) {
        System.out.printf(ViewMessage.TOTAL_RETURN_RATE.getMessage(), calculateTotalReturnRate);
    };
}
