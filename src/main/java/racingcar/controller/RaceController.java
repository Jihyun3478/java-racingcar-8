package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Race;
import racingcar.model.domain.TrialCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public void run() {
        OutputView.requestCarNames();
        Cars cars = inputCars();

        OutputView.requestTrialCount();
        TrialCount trialCount = inputTrialCount();

        OutputView.promptRaceState();
        Race race = new Race(cars, trialCount);
        race.start();

        List<String> winners = race.judgeWinners();
        OutputView.promptWinners(winners);
    }

    private static Cars inputCars() {
        String carNames = InputView.inputCar();
        return new Cars(carNames);
    }

    private TrialCount inputTrialCount() {
        int trialCount = InputView.inputTrialCount();
        return new TrialCount(trialCount);
    }
}
