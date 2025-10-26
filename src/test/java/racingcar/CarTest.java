package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("무작위 값이 4 이상이면, 전진한다.")
    public void 무작위값_4_이상이면_전진() {
        Car car = new Car("pobi");
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 3 이하면, 정지한다.")
    public void 무작위값_3_이하면_정지() {
        Car car = new Car("pobi");
        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiwonijun", "junwonipobi"})
    @DisplayName("자동차 이름이 5자 이하가 아닌 경우 예외가 발생한다.")
    public void 자동차_이름_5자_이하가_아닌_경우_예외_발생(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pob i", "w oni", "ju n"})
    @DisplayName("자동차 이름에 공백이 포함된 경우 예외가 발생한다.")
    public void 자동차_이름_공백_포함된_경우_예외_발생(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 공백이 포함되어 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@#", "$%^", "&*()"})
    @DisplayName("자동차 이름에 문자와 숫자가 입력되지 않은 경우 예외가 발생한다.")
    public void 문자와_숫자가_입력되지_않은_경우_예외_발생(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 문자와 숫자만 가능합니다.");
    }
}
