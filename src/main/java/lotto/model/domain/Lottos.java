package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;
    private int size;

    public Lottos() {
        lottos = new ArrayList<Lotto>();
    }

    private List<Integer> initLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public void createLotto() {
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(initLottoNumbers()));
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
