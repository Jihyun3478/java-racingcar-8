package racingcar.model.domain;

import static racingcar.constant.ErrorMessage.TRIAL_COUNT_INVALID_RANGE;

public class TrialCount {
    private static final int MINIMUM_TRIAL_COUNT = 0;
    private final int trialCount;

    public TrialCount(int trialCount) {
        validateNegative(trialCount);
        this.trialCount = trialCount;
    }

    public int getTrialCount() {
        return trialCount;
    }

    private void validateNegative(int trialCount) {
        if (trialCount <= MINIMUM_TRIAL_COUNT) {
            throw new IllegalArgumentException(TRIAL_COUNT_INVALID_RANGE.getMessage());
        }
    }
}
