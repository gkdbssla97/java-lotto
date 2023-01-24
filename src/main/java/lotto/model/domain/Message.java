package lotto.model.domain;

public enum Message {
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_COUNT("개를 구매했습니다."),

    WINNER_STATISTICS("당첨 통계" + "\n" + "---"),

    TOTAL_YIELD("총 수익률은 "),
    TOTAL_YIELD_MESSAGE_END("%입니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
