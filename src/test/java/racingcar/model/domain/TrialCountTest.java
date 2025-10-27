package racingcar.model.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TrialCountTest {
    @Test
    @DisplayName("시도 횟수는 1 이상이어야 한다.")
    void 시도_횟수_1_이상() {
        assertThatCode(() -> new TrialCount(1))
                .doesNotThrowAnyException();

        assertThatCode(() -> new TrialCount(100))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -1, 0})
    @DisplayName("시도할 횟수가 0 이하일 경우 예외가 발생한다.")
    public void 시도할_횟수_0_이하일_경우_예외_발생(int trialCount) {
        assertThatThrownBy(() -> new TrialCount(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1 이상이어야 합니다.");
    }
}
