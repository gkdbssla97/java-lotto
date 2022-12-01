package lotto.model.service;

import lotto.model.domain.Player;

import java.util.List;

public class PlayerService {

    private Player player;

    public PlayerService() {
        player = new Player();
    }

    public void initPlayerPrice(Integer price) {
        player.initPrice(price);
    }

    public void initPlayerNumbers(List<Integer> playerLottoNumbers) {
        player.initPlayerNumbers(playerLottoNumbers);
    }

    public void initPlayerBonusNumber(Integer playerBonusNumber) {
        player.initPlayerBonusNumber(playerBonusNumber);
    }

    public Player getPlayer() {
        return player;
    }
}
