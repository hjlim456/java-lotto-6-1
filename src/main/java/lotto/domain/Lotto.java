package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.message.ViewMessage;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lottos buyLottoUsingBudget(Budget budget) {
        int lottoCount=budget.getAmount() / 1000;
        Lottos lottos = new Lottos(new ArrayList<>());

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.addLotto(lotto);
        }
        OutputView.printBuyResult(lottoCount, lottos);
        return lottos;
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public String printNumbers() {
        String numberString = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + numberString + "]";
    }

}
