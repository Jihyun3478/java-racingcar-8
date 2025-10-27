package racingcar.model.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private final TrialCount trialCount;

    public Race(Cars cars, TrialCount trialCount) {
        this.cars = cars;
        this.trialCount = trialCount;
    }

    public Cars getCars() {
        return cars;
    }

    public void playRound() {
        cars.moveAll();
    }

    public List<String> judgeWinners() {
        return cars.findWinners();
    }
}
