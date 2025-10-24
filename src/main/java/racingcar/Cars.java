package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<String> cars;

    public Cars(String carNames) {
        validate(carNames);
        cars = parseCarNames(carNames.trim());
    }

    public void validate(String carNames) {
        validateIsEmpty(carNames);
        validateEdgeWithComma(carNames);
        validateOtherDelimiter(carNames);
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
}
