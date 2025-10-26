package racingcar.model.domain;

import java.util.List;
import racingcar.RandomGenerator;

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
        for (Car car : cars.getCars()) {
            int randomNumber = RandomGenerator.generateNumber();
            car.move(randomNumber);
        }
    }

    public List<String> judgeWinners() {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == cars.getMaxPosition())
                .map(Car::getName)
                .toList();
    }
}
