package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import racingcar.model.domain.Cars;
import racingcar.model.domain.Race;
import racingcar.model.domain.TrialCount;
import racingcar.view.OutputView;

public class RaceController {
    public void run() {
        OutputView.requestCarNames();
        String carNames = Console.readLine();
        Cars cars = new Cars(carNames);

        OutputView.requestTrialCount();
        TrialCount trialCount = getTrialCount();

        OutputView.promptRaceState();
        Race race = new Race(cars, trialCount);
        race.start();

        List<String> winners = race.judgeWinners();
        OutputView.promptWinners(winners);
    }

    private TrialCount getTrialCount() {
        int trialCount = 0;
        try {
            String inputTrialCount = Console.readLine();
            if (Objects.isNull(inputTrialCount) || inputTrialCount.trim().isEmpty()) {
                throw new IllegalArgumentException("입력이 빈 값입니다.");
            }
            trialCount = Integer.parseInt(inputTrialCount);
            return new TrialCount(trialCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자이어야 합니다.");
        }
    }
}
