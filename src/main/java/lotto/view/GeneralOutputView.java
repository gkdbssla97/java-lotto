package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.Message;
import lotto.model.domain.Rank;
import lotto.model.service.LottoService;

import java.util.Arrays;
import java.util.List;

public class GeneralOutputView {

    public static void printLottos(LottoService lottoService) {
        System.out.println("\n" + lottoService.getLottoSize() + Message.OUTPUT_PURCHASE_COUNT.getMessage());
        Lottos lottos = lottoService.getLottos();
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void printResult(LottoService lottoService) {
        Rank rank = lottoService.getRank();
        System.out.println("\n" + Message.WINNER_STATISTICS.getMessage());
        System.out.println(Message.MATCHING_THREE.getMessage() + rank.toString(rank.getRankChart().get("3")));
        System.out.println(Message.MATCHING_FOUR.getMessage() + rank.toString(rank.getRankChart().get("4")));
        System.out.println(Message.MATCHING_FIVE.getMessage() + rank.toString(rank.getRankChart().get("5")));
        System.out.println(Message.MATCHING_FIVE_WITH_BONUS.getMessage() + rank.toString(rank.getRankChart().get("5 + 보너스")));
        System.out.println(Message.MATCHING_SIX.getMessage() + rank.toString(rank.getRankChart().get("6")));
        System.out.println(Message.TOTAL_YIELD.getMessage() + rank.toString(String.format("%.1f", rank.setYield(lottoService.getPlayerPrice()))));
    }

}

/**
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */
