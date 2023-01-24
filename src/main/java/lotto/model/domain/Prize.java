package lotto.model.domain;

public enum Prize {

    MATCHING_THREE("3개 일치 (5,000원) - ", 5000, 0, 3),
    MATCHING_FOUR("4개 일치 (50,000원) - ", 50000, 0, 4),
    MATCHING_FIVE("5개 일치 (1,500,000원) - ", 1500000, 0, 5),
    MATCHING_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 0, 6),
    MATCHING_SIX("6개 일치 (2,000,000,000원) - ", 2000000000, 0, 7);

    private String winningMessage;
    private int reward;
    private int matchingCount;
    private int ranking;

    Prize(String winningMessage, int reward, int matchingCount, int ranking) {
        this.winningMessage = winningMessage;
        this.reward = reward;
        this.matchingCount = matchingCount;
        this.ranking = ranking;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    public int getReward() {
        return reward;
    }

    public void increaseMatchingPoint() {
        this.matchingCount++;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getRanking() {
        return ranking;
    }

    public void initMatchingCount() {
        this.matchingCount = 0;
    }
}
