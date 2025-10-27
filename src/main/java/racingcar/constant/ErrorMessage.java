package racingcar.constant;

public enum ErrorMessage {
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_CONTAINS_WHITESPACE("자동차 이름에 공백이 포함되어 있습니다."),
    CAR_NAME_INVALID_FORMAT("자동차 이름은 문자와 숫자만 가능합니다."),

    CARS_INPUT_EMPTY("입력이 빈 값입니다."),
    CARS_INPUT_INVALID_COMMA("쉼표(,)를 기준으로 올바르게 입력해주세요."),
    CARS_DUPLICATE_NAME("자동차 이름은 중복되지 않아야 합니다."),
    CARS_EXCEED_LIMIT("자동차 수는 10대까지 가능합니다."),

    TRIAL_COUNT_INVALID_RANGE("시도할 횟수는 1 이상이어야 합니다."),
    TRIAL_COUNT_ALWAYS_NUMBER("시도할 횟수는 숫자이어야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
