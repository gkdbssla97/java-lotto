package lotto.model.service;

import lotto.model.domain.Player;
import lotto.model.domain.Prize;

public class PrizeService {
    Player player;

    public PrizeService(Player player) {
        this.player = player;
    }

    public void initPrize() {
        for (Prize prize : Prize.values()) {
            prize.initMatchingCount();
        }
    }

    public void findByRanking(int ranking) {
        for (Prize prize : Prize.values()) {
            if (ranking == prize.getRanking()) {
                prize.increaseMatchingPoint();
            }
        }
    }

    public String calculateTotalPrize() {
        int total = 0;
        for (Prize prize : Prize.values()) {
            total += prize.getReward() * prize.getMatchingCount();
        }

        return String.format("%.1f", (double)(total * 100) / player.getPrice());
    }
}
