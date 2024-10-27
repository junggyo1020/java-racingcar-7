package racingcar.exception;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다."),
    INVALID_TRIAL_COUNT("시도 횟수는 1 이상의 정수로 입력해야 합니다."),
    INVALID_RANDOM_RANGE("전진 조건을 설정하는 값은 0에서 9 사이여야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}