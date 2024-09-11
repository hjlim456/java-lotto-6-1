package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @DisplayName("등수계산로직 확인테스트")
    @ParameterizedTest
    @MethodSource("ValuesByRank")
    void compareLottosTest(Lottos purchasedLottos,  Map<String, Long> expectedResults) {
        //given

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        //when
        Map<String, Long> purchasedLottosResult = Lottos.compareLottos(purchasedLottos, winningLotto, bonusNumber);
        //then
        Assertions.assertThat(purchasedLottosResult)
                .isEqualTo(expectedResults);
    }

    static Stream<Arguments> ValuesByRank() {
        return Stream.of(
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)) // 1등
                )), Map.of(
                        "3개 일치 (5,000원) - ", 0L,
                        "4개 일치 (50,000원) - ", 0L,
                        "5개 일치 (1,500,000원) - ", 0L,
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0L,
                        "6개 일치 (2,000,000,000원) - ", 1L
                )),
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 2등
                )), Map.of(
                        "3개 일치 (5,000원) - ", 0L,
                        "4개 일치 (50,000원) - ", 0L,
                        "5개 일치 (1,500,000원) - ", 0L,
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 1L,
                        "6개 일치 (2,000,000,000원) - ", 0L
                )),
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)) // 3등
                )), Map.of(
                        "3개 일치 (5,000원) - ", 0L,
                        "4개 일치 (50,000원) - ", 0L,
                        "5개 일치 (1,500,000원) - ", 1L,
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0L,
                        "6개 일치 (2,000,000,000원) - ", 0L
                )),
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)) // 4등
                )), Map.of(
                        "3개 일치 (5,000원) - ", 0L,
                        "4개 일치 (50,000원) - ", 1L,
                        "5개 일치 (1,500,000원) - ", 0L,
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0L,
                        "6개 일치 (2,000,000,000원) - ", 0L
                )),
                Arguments.of(new Lottos(List.of(
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)) // 5등
                )), Map.of(
                        "3개 일치 (5,000원) - ", 1L,
                        "4개 일치 (50,000원) - ", 0L,
                        "5개 일치 (1,500,000원) - ", 0L,
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0L,
                        "6개 일치 (2,000,000,000원) - ", 0L
                ))
        );
}


}