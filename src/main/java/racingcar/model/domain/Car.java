package racingcar.model.domain;

import static racingcar.constant.ErrorMessage.CAR_NAME_CONTAINS_WHITESPACE;
import static racingcar.constant.ErrorMessage.CAR_NAME_INVALID_FORMAT;
import static racingcar.constant.ErrorMessage.CAR_NAME_TOO_LONG;

import java.util.Objects;

public class Car {
    private static final int ADVANCE_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_FORMAT_REGEX = "^[a-zA-Z가-힣0-9]+$";

    private final String name;
    private int position;

    public Car(String carName) {
        validate(carName.trim());
        this.name = carName;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= ADVANCE_CONDITION) {
            this.position += 1;
        }
    }

    public boolean isMaxPosition(int position) {
        return this.position == position;
    }

    private void validate(String carName) {
        validateNameLength(carName.length());
        validateInsideWhiteSpace(carName);
        validateNameFormat(carName);
    }

    private void validateNameLength(int carNameLength) {
        if (carNameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    private void validateInsideWhiteSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(CAR_NAME_CONTAINS_WHITESPACE.getMessage());
        }
    }

    private void validateNameFormat(String carName) {
        if (!carName.matches(NAME_FORMAT_REGEX)) {
            throw new IllegalArgumentException(CAR_NAME_INVALID_FORMAT.getMessage());
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
