package racingcar;

public class TrialCount {
    private final int trialCount;

    public TrialCount(int trialCount) {
        validateNegative(trialCount);
        this.trialCount = trialCount;
    }

    private void validateNegative(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }
}
