package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomGenerator {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    private RandomGenerator() {}

    public static int generateNumber() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }
}
