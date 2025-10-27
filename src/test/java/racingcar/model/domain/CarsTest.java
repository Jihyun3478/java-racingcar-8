package racingcar.model.domain;

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
        Cars cars = Cars.from(carNames);

        assertEquals(3, cars.getCars().size());
    }

    @Test
    @DisplayName("입력이 빈 값인 경우 예외가 발생한다.")
    public void 빈_값인_경우_예외_발생() {
        assertAll(
                () -> assertThatThrownBy(() -> Cars.from(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 빈 값입니다."),
                () -> assertThatThrownBy(() -> Cars.from(null))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 빈 값입니다.")
        );

    }

    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni,jun", "pobi,woni,jun,,", "pobi.woni.jun", "pobi,woni,,jun"})
    @DisplayName("자동차 이름이 쉼표(,)를 기준으로 올바르게 입력되지 않은 경우 예외가 발생한다.")
    public void 쉼표를_기준으로_올바르게_입력되지_않은_경우_예외_발생(String cars) {
        assertThatThrownBy(() -> Cars.from(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표(,)를 기준으로 올바르게 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi,jun", "woni,woni,woni"})
    @DisplayName("자동차 이름이 쉼표(,)를 기준으로 올바르게 입력되지 않은 경우 예외가 발생한다.")
    public void 이름이_중복된_경우_예외_발생(String cars) {
        assertThatThrownBy(() -> Cars.from(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("자동차 수가 10대를 초과할 경우 예외가 발생한다.")
    public void 자동차_수_10대_초과할_경우_예외_발생() {
        String cars = "포비,워니,왼손,준,네오,브라운,새로이,감자,감자들,짱감자,우아한감자";
        assertThatThrownBy(() -> Cars.from(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 수는 10대까지 가능합니다.");
    }
}
