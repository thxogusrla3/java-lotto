package lotto.domain;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Number> lottoNumbers;
    private static final int REPEAT = 6;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<Number>();

        for (int i = 0; i <REPEAT; i++) {
            addNumber(new Number(NumberUtil.randomNum()));
        }
        sort();
    }
    public LottoNumbers(List<Integer> integerNumbers) {
        lottoNumbers = new ArrayList<Number>();

        for (int number : integerNumbers) {
            addNumber(new Number(number));
        }

        sort();
    }

    private void addNumber(Number number) {
        checkDuple(number);
        lottoNumbers.add(number);
    }

    private void checkDuple(Number insertNum) {
        if(isContains(insertNum.getNumber())) {
            throw new IllegalArgumentException("중복된 데이터가 존재합니다.");
        }
    }

    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean isContains(int number) {
        return this.lottoNumbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList())
                .contains(number);
    }

    public List<Number> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
