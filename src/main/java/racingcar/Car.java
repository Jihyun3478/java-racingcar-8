package racingcar;

public class Car {
    private final String name;

    public Car(String carName) {
        validate(carName.trim());
        this.name = carName;
    }

    private void validate(String carName) {
        validateNameLength(carName.length());
        validateInsideWhiteSpace(carName);
        validateNameFormat(carName);
    }

    private void validateNameLength(int carNameLength) {
        if (carNameLength > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateInsideWhiteSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    private void validateNameFormat(String carName) {
        if (!carName.matches("^[a-zA-Z가-힣0-9]+$")) {
            throw new IllegalArgumentException("자동차 이름은 문자와 숫자만 가능합니다.");
        }
    }
}
