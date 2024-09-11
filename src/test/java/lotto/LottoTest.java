package lotto;

import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력금액만큼 로또 구매 로직 성공 테스트")
    @Test
    void buyLottoUsingBudgetSuccessTest() {
        //given
        Lottos purchasedLotto = Lotto.buyLottoUsingBudget(new Budget(3000));
        //when
        int lottoCount = purchasedLotto.getLottosSize();  // Lottos에 있는 Lotto 객체의 개수를 가져옴
        //then
        Assertions.assertThat(lottoCount).isEqualTo(3);
    }
}