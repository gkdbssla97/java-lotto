package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private int purchasePrice;

    public Player() {
    }

    public int enterPurchasePrice() {
        String purchasePrice = Console.readLine();
        int purchasePriceInt = LottoException.exceptionInvalidPurchasePrice(purchasePrice);
        LottoException.exceptionDividedIntoThousands(purchasePriceInt);
        return purchasePriceInt;
    }

    public List<String> enterLottoNumbers() {
        String inputLottoNumbers = Console.readLine();
        String[] lottoNumbers = LottoException.exceptionInvalidLottoNumber(inputLottoNumbers);
        return new ArrayList<>(Arrays.asList(lottoNumbers));
    }
}