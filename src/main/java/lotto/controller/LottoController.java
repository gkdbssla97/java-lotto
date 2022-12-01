package lotto.controller;

import lotto.model.service.LottoService;
import lotto.model.service.PlayerService;
import lotto.validator.PlayerValidator;
import lotto.view.PlayerInputView;

import java.util.List;

public class LottoController {

    private PlayerService playerService;
    private LottoService lottoService;

    public LottoController() {
        this.playerService = new PlayerService();
        this.lottoService = new LottoService(playerService.getPlayer());
    }

    public void initPlayerPrice() {
        String price = PlayerInputView.inputPurchasePrice();
        Integer playerPrice = PlayerValidator.validatorPlayerPrice(price);
        playerService.initPlayerPrice(playerPrice);
        initLottos(playerPrice);
    }

    public void initPlayerNumbers() {
        String numbers = PlayerInputView.inputPlayerLottoNumbers();
        List<Integer> playerNumbers = PlayerValidator.validatorPlayerNumber(numbers);
        playerService.initPlayerNumbers(playerNumbers);
    }

    public void initPlayerBonusNumbers() {
        String playerBonusNumber = PlayerInputView.inputPlayerBonusNumber();
        Integer bonusNumber = PlayerValidator.validatorPlayerBonusNumber(playerBonusNumber, playerService.getPlayer());
        playerService.initPlayerBonusNumber(bonusNumber);
    }

    private void initLottos(Integer playerPrice) {
        lottoService.initLottoCount(playerPrice);
        lottoService.initLottosNumber();
    }

    public void calculateWinningStatistics() {
        lottoService.calculateWinningStatistics();
    }

    public LottoService getLottoService() {
        return lottoService;
    }
}
