package lotto.view;

import lotto.model.domain.*;
import lotto.model.service.LottoService;
import lotto.model.service.PrizeService;

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

    public static void printResult(PrizeService prizeService) {
        System.out.println("\n" + Message.WINNER_STATISTICS.getMessage());
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getWinningMessage() + prize.getMatchingCount() + "개");
        }
        System.out.println(Message.TOTAL_YIELD.getMessage()
                + prizeService.calculateTotalPrize() + Message.TOTAL_YIELD_MESSAGE_END.getMessage() );
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
