package lotto.domain;

import java.util.List;

public record Lottos(List<Lotto> lottoList) {
    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

}
