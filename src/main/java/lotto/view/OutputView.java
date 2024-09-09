package lotto.view;

import java.util.Map;

public class OutputView {

    public static void printResult(Map<String, Long> resultMap) {
        // 각 항목을 출력하는 메서드
        resultMap.forEach((key, value) ->{
            System.out.println(key + value + "개");
                }
        );
    }
}
