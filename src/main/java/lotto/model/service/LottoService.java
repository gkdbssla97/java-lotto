package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.Player;
import lotto.model.domain.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {

    private Player player;
    private Lottos lottos;
    private Rank rank;

    public LottoService(Player player) {
        this.player = player;
        this.lottos = new Lottos();
        this.rank = player.getRank();

    }

    public void initLottoCount(Integer price) {
        lottos.setSize(price / 1000);
    }

    public void initLottosNumber() {
        lottos.createLotto();
    }

    public int getLottoSize() {
        return lottos.getSize();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void calculateWinningStatistics() {
        List<Lotto> lottoList = lottos.getLottos();
        List<Integer> playerNumbers = player.getPlayerNumbers();
        List<Integer> rankCount = Arrays.asList(0, 0, 0, 0, 0);
        for (int i = 0; i < lottoList.size(); i++) {
            int count = 0;
            boolean isBonusNumberContain = false;
            Lotto lotto = lottoList.get(i);
            List<Integer> numbers = lotto.getNumbers();
            for (int j = 0; j < playerNumbers.size(); j++) {
//                System.out.println(numbers.contains(playerNumbers.get(j)));
                if (numbers.contains(playerNumbers.get(j))) {
                    count += 1;
                }
                if (numbers.contains(player.getPlayerBonusNumber())) {
                    isBonusNumberContain = true;
                }
            }
            if (count == 5 && isBonusNumberContain) {
                rank.setRankChart(0);
            } else if (count >= 3) {
                rank.setRankChart(count);
            }
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Integer getPlayerPrice() {
        return player.getPrice();
    }
}
