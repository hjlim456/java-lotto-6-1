package lotto.domain;

import java.util.List;
import java.util.Map;
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
    public static void compareLottos(Map<String, Long> resultMap, Lottos purchasedLottos, Lotto winningLotto, int bonusNumber) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();

        for (Lotto lotto : purchasedLottos.lottoList()){
            List<Integer> purchasedNumbers = lotto.getNumbers();
            long matchCount  = purchasedNumbers.stream()
                    .filter(winningLottoNumbers::contains)
                    .count();
            boolean hasBonus = purchasedNumbers.contains(bonusNumber);
            updateResult(resultMap, matchCount, hasBonus);
        }
    }

    public static void updateResult(Map<String, Long> resultMap, long matchCount, boolean hasBonus) {
        resultMap.putIfAbsent("3개 일치 (5,000원) - ", 0L);
        resultMap.putIfAbsent("4개 일치 (50,000원) - ", 0L);
        resultMap.putIfAbsent("5개 일치 (1,500,000원) - ", 0L);
        resultMap.putIfAbsent("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0L);
        resultMap.putIfAbsent("6개 일치 (2,000,000,000원) - ", 0L);

        if (matchCount == 3) {
            resultMap.merge("3개 일치 (5,000원) - ", 1L, Long::sum);
        }
        if (matchCount == 4) {
            resultMap.merge("4개 일치 (50,000원) - ", 1L, Long::sum);
        }
        if (matchCount == 5 && hasBonus) {
            resultMap.merge("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 1L, Long::sum);
        }
        if (matchCount == 5) {
            resultMap.merge("5개 일치 (1,500,000원) - ", 1L, Long::sum);
        }
        if (matchCount == 6) {
            resultMap.merge("6개 일치 (2,000,000,000원) - ", 1L, Long::sum);
        }
    }
    public int getLottosSize() {
        return lottoList.size();
    }
}
