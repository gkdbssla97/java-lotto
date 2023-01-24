package lotto.model.service;

import lotto.model.domain.*;

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

    public void calculateWinningStatistics(PrizeService prizeService) {
        for (Lotto lotto : lottos.getLottos()) {
            int count = 0;
            boolean isBonusNumberContain = false;
            List<Integer> numbers = lotto.getNumbers();
            for (Integer playerNumber : player.getPlayerNumbers()) {
                if (numbers.contains(playerNumber)) {
                    count += 1;
                }
                if (numbers.contains(player.getPlayerBonusNumber())) {
                    isBonusNumberContain = true;
                }
            }
            setWinningStatistics(count, isBonusNumberContain, prizeService);
        }
    }

    private void setWinningStatistics(int ranking, boolean isBonusNumberContain, PrizeService prizeService) {
        if (ranking == 5 && isBonusNumberContain) {
            Prize.MATCHING_FIVE_WITH_BONUS.increaseMatchingPoint();
        } else if (ranking >= 3) {
            prizeService.findByRanking(ranking);
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Integer getPlayerPrice() {
        return player.getPrice();
    }
}
