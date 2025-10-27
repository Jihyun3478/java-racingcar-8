package racingcar.view;

import static racingcar.constant.ErrorMessage.TRIAL_COUNT_ALWAYS_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCar() {
        return Console.readLine();
    }

    public static int inputTrialCount() {
        try {
            String inputTrialCount = Console.readLine();
            return Integer.parseInt(inputTrialCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRIAL_COUNT_ALWAYS_NUMBER.getMessage());
        }
    }

    public static void close() {
        Console.close();
    }
}
