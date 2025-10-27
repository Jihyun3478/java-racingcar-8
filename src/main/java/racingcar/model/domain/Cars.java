package racingcar.model.domain;

import static racingcar.constant.ErrorMessage.CARS_DUPLICATE_NAME;
import static racingcar.constant.ErrorMessage.CARS_EXCEED_LIMIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.RandomGenerator;
import racingcar.util.CarNameParser;

public class Cars {
    private static final int MAX_CARS_SIZE = 10;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validate(cars);
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String carNames) {
        List<Car> cars = CarNameParser.parse(carNames);
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = RandomGenerator.generateNumber();
            car.move(randomNumber);
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void validate(List<Car> cars) {
        validateDuplicate(cars);
        validateCarCount(cars);
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> notDuplicateCars = new HashSet<>(cars);

        if (cars.size() != notDuplicateCars.size()) {
            throw new IllegalArgumentException(CARS_DUPLICATE_NAME.getMessage());
        }
    }

    private void validateCarCount(List<Car> cars) {
        if (cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException(CARS_EXCEED_LIMIT.getMessage());
        }
    }
}
