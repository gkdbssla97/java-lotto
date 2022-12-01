package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.domain.Message;

public class PlayerInputView {

    public static String inputPurchasePrice() {
        System.out.println(Message.INPUT_PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputPlayerLottoNumbers() {
        System.out.println("\n" + Message.INPUT_LOTTO_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputPlayerBonusNumber() {
        System.out.println("\n" + Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
