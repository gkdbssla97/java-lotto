package lotto;

import lotto.controller.LottoController;
import lotto.model.domain.Player;
import lotto.view.GeneralInputView;
import lotto.view.GeneralOutputView;
import lotto.view.PlayerInputView;

public class Game {
    private LottoController lottoController;

    public Game() {
        this.lottoController = new LottoController();
        play();
    }

    void play() {
        try {
            lottoController.initPlayerPrice();
            lottoController.initMatchCount();
            GeneralOutputView.printLottos(lottoController.getLottoService());
            lottoController.initPlayerNumbers();
            lottoController.initPlayerBonusNumbers();
            lottoController.calculateWinningStatistics();
            GeneralOutputView.printResult(lottoController.getPrizeService());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

/**
 *
 * 구입금액을 입력해 주세요.
 * 8000
 *
 * 8개를 구매했습니다.
 * [8, 21, 23, 41, 42, 43]
 * [3, 5, 11, 16, 32, 38]
 * [7, 11, 16, 35, 36, 44]
 * [1, 8, 11, 31, 41, 42]
 * [13, 14, 16, 38, 42, 45]
 * [7, 11, 30, 40, 42, 43]
 * [2, 13, 22, 32, 38, 45]
 * [1, 3, 5, 14, 22, 45]
 *
 * 당첨 번호를 입력해 주세요.
 * 1,2,3,4,5,6
 *
 * 보너스 번호를 입력해 주세요.
 * 7
 *
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */