package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다.")
    public void 자동차_이름은_쉼표를_기준으로_구분() {
        String carNames = "pobi,woni,jun";
        Cars cars = new Cars(carNames);

        assertEquals(3, cars.size());
    }

    @Test
    @DisplayName("입력이 빈 값인 경우 예외가 발생한다.")
    public void 빈_값인_경우_예외_발생() {
        assertAll(
                () -> assertThatThrownBy(() -> new Cars(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 빈 값입니다."),
                () -> assertThatThrownBy(() -> new Cars(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 빈 값입니다.")
        );

    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", "pobi,woni,jun,,", "pobi.woni.jun", "pobi,woni,,jun"})
    @DisplayName("자동차 이름이 쉼표(,)를 기준으로 올바르게 입력되지 않은 경우 예외가 발생한다.")
    public void 쉼표를_기준으로_올바르게_입력되지_않은_경우_예외_발생(String carNames) {
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표(,)를 기준으로 올바르게 입력해주세요.");
    }
}
