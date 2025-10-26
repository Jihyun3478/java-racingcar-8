package racingcar;

import java.util.List;

public class Race {
    private final Cars cars;
    private final TrialCount trialCount;

    public Race(Cars cars, TrialCount trialCount) {
        this.cars = cars;
        this.trialCount = trialCount;
    }

    public void start() {
        for (int raceCount = 0; raceCount < trialCount.getTrialCount(); raceCount++) {
            for (Car car : cars.getCars()) {

                int randomNumber = RandomGenerator.generateNumber();
                car.move(randomNumber);
                System.out.println(car.toString());
            }
            System.out.println();
        }
    }

    public List<String> judgeWinners() {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == cars.getMaxPosition())
                .map(Car::getName)
                .toList();
    }
}
