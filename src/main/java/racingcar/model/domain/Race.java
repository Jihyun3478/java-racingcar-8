package racingcar.model.domain;

import java.util.List;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.moveAll();
    }

    public List<String> judgeWinners() {
        return cars.findWinners();
    }

    public List<String> currentCarInfos() {
        return cars.getCarInfos();
    }
}
