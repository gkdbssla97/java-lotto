package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        exceptionLottoNumberOutOfRange(numbers);
        exceptionLottoByDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "[ERROR] 로또 번호 개수는 6개여야 합니다.");
            throw e;
        }
    }

    // TODO: 추가 기능 구현
    public void processLotto(List<List<Integer>> userLottos, int bonusNumber, int purchasePrice) {
        HashMap<Integer, Integer> matchingPair = createLottoHashSet();
        calculateWinningStatistics(userLottos, bonusNumber, matchingPair);
        printWinningStatistics(matchingPair, purchasePrice);
    }

    private HashMap<Integer, Integer> createLottoHashSet() {
        return new HashMap<>(Constant.LOTTO_WINNING_SIZE) {
            {
                for (int i = 3; i <= 7; i++) {
                    put(i, 0);
                }
            }
        };
    }

    private void printWinningStatistics(HashMap<Integer, Integer> matchingPair, int purchasePrice) {
        System.out.println(Constant.THREE_MATCHING + " - " + matchingPair.get(3) + "개");
        System.out.println(Constant.FOUR_MATCHING + " - " + matchingPair.get(4) + "개");
        System.out.println(Constant.FIVE_MATCHING + " - " + matchingPair.get(5) + "개");
        System.out.println(Constant.FIVE_MATCHING_WITH_BONUS_NUM + " - " + matchingPair.get(7) + "개");
        System.out.println(Constant.SIX_MATCHING + " - " + matchingPair.get(6) + "개");

        printTotalYield(purchasePrice, matchingPair);
    }

    private void printTotalYield(double purchasePrice, HashMap<Integer, Integer> matchingPair) {
        double yield = calculateTotalYield(purchasePrice, matchingPair);
        System.out.println(Constant.TOTAL_YIELD + String.format("%.1f", yield) + "%입니다.");
    }

    private double calculateTotalYield(double purchasePrice, HashMap<Integer, Integer> matchingPair) {
        int sum = 0;
        for (CalculatorLottoType type : CalculatorLottoType.values()) {
            sum += matchingPair.get(type.getMatchingCount()) * type.getMatchingCountMoney();
        }
        return (double) sum * Constant.YIELD_OPERAND / purchasePrice;
    }

    private void calculateWinningStatistics(List<List<Integer>> userLottos, int bonusNumber, HashMap<Integer, Integer> matchingPair) {
        for (List<Integer> userLotto : userLottos) {
            int matchingCount = getMatchingCountByUserLottos(userLotto);
            setPairWithMatchingLottoNumber(bonusNumber, matchingPair, userLotto, matchingCount);
        }
    }

    private void setPairWithMatchingLottoNumber(int bonusNumber, HashMap<Integer, Integer> matchingPair, List<Integer> userLotto, int matchingCount) {
        if (matchingCount >= 3 && matchingCount <= 6) {
            if (matchingCount == 5 && userLotto.contains(bonusNumber)) {
                matchingPair.replace(7, matchingPair.get(7) + 1);
            } else {
                matchingPair.replace(matchingCount, matchingPair.get(matchingCount) + 1);
            }
        }
    }

    private int getMatchingCountByUserLottos(List<Integer> userLotto) {
        int matchingCount = 0;
        for (Integer number : numbers) {
            if (userLotto.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private void exceptionLottoByDuplicatedNumber(List<Integer> numbers) {
        HashSet<Integer> lottoHashSet = new HashSet<Integer>(numbers);
        if (lottoHashSet.size() != 6) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "로또 번호는 중복될 수 없습니다.");
            throw e;
        }
    }

    public void exceptionBonusNumberByDuplicatedLotto(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "보너스 번호는 로또 번호와 중복될 수 없습니다.");
            throw e;
        }
    }

    private void exceptionLottoNumberOutOfRange(List<Integer> numbers) {
        for (Integer lottoNumber : numbers) {
            if (lottoNumber > Constant.LOTTO_MAX_RANGE || lottoNumber < Constant.LOTTO_MIN_RANGE) {
                IllegalArgumentException e = new IllegalArgumentException();
                System.out.println(Constant.ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw e;

            }
        }
    }

    public void exceptionBonusNumberOutOfRange(int bonusNumber) {
        if (bonusNumber > Constant.LOTTO_MAX_RANGE || bonusNumber < Constant.LOTTO_MIN_RANGE) {
            IllegalArgumentException e = new IllegalArgumentException();
            System.out.println(Constant.ERROR_MESSAGE + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw e;
        }
    }
}