package lotto.validator;

import lotto.model.domain.Player;
import lotto.util.Parsing;
import lotto.view.ExceptionView;

import java.util.List;

public class PlayerValidator {

    public static Integer validatorPlayerPrice(String Price) {
        try {
            Integer playerPrice = isNumeric(Price);
            if (isDividedThousands(playerPrice)) {
                return playerPrice;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionView.ERROR_CODE.getMessage()
                    + ExceptionView.ERROR_PURCHASE_PRICE.getMessage());
        } return 0;
    }

    public static Integer isNumeric(String playerPrice) {
        return Integer.parseInt(playerPrice);
    }

    public static Integer validatorPlayerBonusNumber(String number, Player player) {
        List<Integer> bonusNumber = isNumericNumbers(number);
        if (validRangeNumber(bonusNumber) && !validDuplicatedNumber(bonusNumber, player.getPlayerNumbers()))
            return bonusNumber.get(0);
        throw new IllegalArgumentException(ExceptionView.ERROR_CODE.getMessage()
                + ExceptionView.ERROR_BONUS_NUMBER_DISTINCT.getMessage());
    }

    private static boolean isDividedThousands(Integer playerPrice) {
        return (playerPrice % 1000) == 0 && playerPrice != 0;
    }

    public static List<Integer> validatorPlayerNumber(String numbers) {
        List<Integer> numericNumbers = isNumericNumbers(numbers);
        if (validRangeNumber(numericNumbers) && validDistinctNumber(numericNumbers))
            return numericNumbers;
        throw new IllegalArgumentException(ExceptionView.ERROR_CODE.getMessage()
                + ExceptionView.ERROR_NUMBER_DISTINCT.getMessage());
    }

    private static List<Integer> isNumericNumbers(String number) {
        System.out.println(Parsing.parseStringToList(number));
        return Parsing.parseStringToList(number);
    }

    private static boolean validRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> 1 <= number && number <= 45);
    }

    private static boolean validDistinctNumber(List<Integer> numbers) {
        System.out.println(numbers.stream().distinct().count());
        return numbers.stream()
                .distinct()
                .count() == 6;
    }

    private static boolean validDuplicatedNumber(List<Integer> bonusNumber, List<Integer> playerNumbers) {
        return playerNumbers.contains(bonusNumber.get(0));
    }
}


/**
 * 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. -
 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생
 * "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료
 * 로또 번호와 중복되는 보너스번호가 있으면 예외 발생
 * 번호 입력 시 예외 발생
 * 1~45 숫자 범위 확인
 * 문자인지 확인
 * " ," 로 구분되는지 확인
 */