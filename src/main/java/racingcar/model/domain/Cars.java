package racingcar.model.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        validate(carNames);
        cars = addCar(carNames);
    }

    public void validate(String carNames) {
        validateIsEmpty(carNames);
        validateEdgeWithComma(carNames);
        validateOtherDelimiter(carNames);
    }

    public List<Car> addCar(String carNames) {
        List<String> cars = parseCarNames(carNames.trim());
        validateDuplicate(cars);
        validateCarCount(cars);
        return cars.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public int size() {
        return cars.size();
    }

    private List<String> parseCarNames(String carNames) {
        String[] extractCarNames = carNames.split(",");
        validateNoEmptyName(extractCarNames);
        return Arrays.stream(extractCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }


    private void validateIsEmpty(String carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new IllegalArgumentException("입력이 빈 값입니다.");
        }
    }

    private void validateEdgeWithComma(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
        }
    }

    private void validateOtherDelimiter(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
        }
    }

    private void validateNoEmptyName(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
            }
        }
    }

    private void validateDuplicate(List<String> cars) {
        Set<String> notDuplicateCars = new HashSet<>(cars);

        if (cars.size() != notDuplicateCars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }

    private void validateCarCount(List<String> cars) {
        if (cars.size() > 10) {
            throw new IllegalArgumentException("자동차 수는 10대까지 가능합니다.");
        }
    }
}
