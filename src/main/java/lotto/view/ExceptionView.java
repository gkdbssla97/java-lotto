package lotto.view;

public enum ExceptionView {
    ERROR_CODE("[ERROR] "),
    ERROR_PURCHASE_PRICE("구입 금액은 1,000원으로 나누어 떨어져야 합니다."),
    ERROR_NUMBER_FORMAT("로또번호는 1에서 45 사이여야 합니다."),
    ERROR_NUMBER_DISTINCT("로또번호는 중복되면 안됩니다."),
    ERROR_NUMBER_SIZE("로또번호는 6개여야 합니다."),
    ERROR_BONUS_NUMBER_DISTINCT("보너스 번호는 로또번호와 중복되면 안됩니다.");

    private String message;

    ExceptionView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
