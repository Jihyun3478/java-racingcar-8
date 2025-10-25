package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomGenerator {
    private RandomGenerator() {}

    public static int generateNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
