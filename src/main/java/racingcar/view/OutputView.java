package racingcar.view;

import static racingcar.constant.OutputMessage.PROMPT_RACE_RESULT;
import static racingcar.constant.OutputMessage.PROMPT_WINNER;
import static racingcar.constant.OutputMessage.REQUEST_CAR_NAMES;
import static racingcar.constant.OutputMessage.REQUEST_TRIAL_COUNT;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Cars;

public class OutputView {
    public static void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES.getMessage());
    }

    public static void requestTrialCount() {
        System.out.println(REQUEST_TRIAL_COUNT.getMessage());
    }

    public static void promptRaceState() {
        System.out.println(PROMPT_RACE_RESULT.getMessage());
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void promptWinners(List<String> winners) {
        System.out.print(PROMPT_WINNER.getMessage() + String.join(", ", winners));
    }
}
