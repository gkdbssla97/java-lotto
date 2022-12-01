package lotto.model.domain;

public enum Message {
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_COUNT("개를 구매했습니다."),

    WINNER_STATISTICS("당첨 통계" + "\n" + "---"),
    MATCHING_THREE("3개 일치 (5,000원) - ", 5000 ),
    MATCHING_FOUR("4개 일치 (50,000원) - ", 50000),
    MATCHING_FIVE("5개 일치 (1,500,000원) - ", 1500000),
    MATCHING_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    MATCHING_SIX("6개 일치 (2,000,000,000원) - ", 2000000000),

    TOTAL_YIELD("총 수익률은 ");

    private String message;
    private Integer reward;

    Message(String message) {
        this.message = message;
    }

    Message(String message, Integer reward) {
        this.message = message;
        this.reward = reward;
    }

    public Integer getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
