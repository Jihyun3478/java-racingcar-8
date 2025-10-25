package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    @Test
    @DisplayName("0에서 9 사이의 무작위 값을 구한다.")
    public void 무작위_값_구하기() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(RandomGenerator.generateNumber()).isEqualTo(2);
                    assertThat(RandomGenerator.generateNumber()).isEqualTo(2);
                    assertThat(RandomGenerator.generateNumber()).isEqualTo(4);
                    assertThat(RandomGenerator.generateNumber()).isEqualTo(4);
                    assertThat(RandomGenerator.generateNumber()).isEqualTo(5);
                },
                2, 2, 4, 4, 5
        );
    }
}
