package lotto.model.domain;

import java.util.List;

public class Player {

    private Integer price;
    private List<Integer> playerNumbers;
    private Integer playerBonusNumber;
    private Rank rank;

    public Player() {
        this.rank = new Rank();
    }

    public void initPrice(Integer price) {
        this.price = price;
    }

    public void initPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void initPlayerBonusNumber(Integer playerBonusNumber) {
        this.playerBonusNumber = playerBonusNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public Integer getPlayerBonusNumber() {
        return playerBonusNumber;
    }

    public Rank getRank() {
        return rank;
    }
}
