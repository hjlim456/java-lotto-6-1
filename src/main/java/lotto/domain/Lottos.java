package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public record Lottos(List<Lotto> lottoList) {
    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }
    public String printAllLottoNumbers() {
        return lottoList.stream()
                .map(Lotto::printNumbers)
                .collect(Collectors.joining("\n"));
    }

}
