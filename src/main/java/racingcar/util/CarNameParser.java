package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;

public final class CarNameParser {
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
        String[] extractCarNames = carNames.split(",");
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
            throw new IllegalArgumentException("입력이 빈 값입니다.");
        }
    }

    private static void validateEdgeWithComma(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
        }
    }

    private static void validateOtherDelimiter(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
        }
    }

    private static void validateNoEmptyName(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("쉼표(,)를 기준으로 올바르게 입력해주세요.");
            }
        }
    }
}
