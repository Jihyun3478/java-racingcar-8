package racingcar.model.domain;

import static racingcar.constant.ErrorMessage.TRIAL_COUNT_INVALID_RANGE;

public class TrialCount {
    private final int trialCount;

    public TrialCount(int trialCount) {
        validateNegative(trialCount);
        this.trialCount = trialCount;
    }

    public int getTrialCount() {
        return trialCount;
    }

    private void validateNegative(int trialCount) {
        if (trialCount <= 0) {
            throw new IllegalArgumentException(TRIAL_COUNT_INVALID_RANGE.getMessage());
        }
    }
}
