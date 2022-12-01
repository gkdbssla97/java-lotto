package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ExceptionView;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ExceptionView.ERROR_CODE.getMessage()
                    + ExceptionView.ERROR_NUMBER_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
