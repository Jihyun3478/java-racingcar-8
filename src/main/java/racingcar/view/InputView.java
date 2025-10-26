package racingcar.view;

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
            throw new IllegalArgumentException("시도할 횟수는 숫자이어야 합니다.");
        }
    }

    public static void close() {
        Console.close();
    }
}
