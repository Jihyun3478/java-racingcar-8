package racingcar.model.domain;

import static racingcar.constant.ErrorMessage.TRIAL_COUNT_INVALID_RANGE;

public record TrialCount(int trialCount) {
    private static final int MINIMUM_TRIAL_COUNT = 0;

    public TrialCount {
        validateNegative(trialCount);
    }

    private void validateNegative(int trialCount) {
        if (trialCount <= MINIMUM_TRIAL_COUNT) {
            throw new IllegalArgumentException(TRIAL_COUNT_INVALID_RANGE.getMessage());
        }
    }
}
