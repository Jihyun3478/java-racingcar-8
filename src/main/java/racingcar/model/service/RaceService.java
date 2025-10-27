package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Race;
import racingcar.model.domain.TrialCount;
import racingcar.view.OutputView;

public class RaceService {
    public List<String> start(Cars cars, TrialCount trialCount) {
        Race race = new Race(cars);

        for (int round = 0; round < trialCount.trialCount(); round++) {
            race.playRound();
            OutputView.printRoundResult(race.getCars());
        }
        return race.judgeWinners();
    }
}
