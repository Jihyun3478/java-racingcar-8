package racingcar.controller;

import java.util.List;
import racingcar.model.domain.Cars;
import racingcar.model.domain.TrialCount;
import racingcar.model.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void run() {
        Cars cars = requestInputCars();
        TrialCount trialCount = requestInputTrialCount();

        OutputView.promptRaceState();
        List<String> winners = raceService.start(cars, trialCount);
        OutputView.promptWinners(winners);
    }

    private static Cars requestInputCars() {
        OutputView.requestCarNames();

        String carNames = InputView.inputCar();
        return new Cars(carNames);
    }

    private TrialCount requestInputTrialCount() {
        OutputView.requestTrialCount();

        int trialCount = InputView.inputTrialCount();
        return new TrialCount(trialCount);
    }
}
