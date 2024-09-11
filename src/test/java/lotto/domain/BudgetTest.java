package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @DisplayName("수익금 계산 테스트")
    @Test
    void calculateTotalReturnRateTest() {
        //given
        Budget budget = new Budget(1000); // 투자 금액 1000원
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("3개 일치 (5,000원) - ", 1L); // 5등 당첨 1장
        //when
        double totalReturnRate = Budget.calculateTotalReturnRate(budget, resultMap);
        //then
        Assertions.assertThat(totalReturnRate).isEqualTo(500);
    }
}