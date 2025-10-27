package racingcar.util;

import static racingcar.constant.ErrorMessage.CARS_INPUT_EMPTY;
import static racingcar.constant.ErrorMessage.CARS_INPUT_INVALID_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;

public final class CarNameParser {
    private static final String NAME_DELIMITER = ",";

    private CarNameParser() {}

    public static List<Car> parse(String carNames) {
        validateInputFormat(carNames);
        List<String> names = parseCarNames(carNames);
        return createCars(names);
    }

    private static void validateInputFormat(String carNames) {
        validateIsEmpty(carNames);
        validateEdgeWithComma(carNames);
        validateOtherDelimiter(carNames);
    }

    private static List<String> parseCarNames(String carNames) {
        String[] extractCarNames = carNames.split(NAME_DELIMITER);
        validateNoEmptyName(extractCarNames);

        return Arrays.stream(extractCarNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static List<Car> createCars(List<String> cars) {
        return cars.stream()
                .map(Car::new)
                .toList();
    }

    private static void validateIsEmpty(String carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new IllegalArgumentException(CARS_INPUT_EMPTY.getMessage());
        }
    }

    private static void validateEdgeWithComma(String carNames) {
        if (carNames.startsWith(NAME_DELIMITER) || carNames.endsWith(NAME_DELIMITER)) {
            throw new IllegalArgumentException(CARS_INPUT_INVALID_COMMA.getMessage());
        }
    }

    private static void validateOtherDelimiter(String carNames) {
        if (!carNames.contains(NAME_DELIMITER)) {
            throw new IllegalArgumentException(CARS_INPUT_INVALID_COMMA.getMessage());
        }
    }

    private static void validateNoEmptyName(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(CARS_INPUT_INVALID_COMMA.getMessage());
            }
        }
    }
}
