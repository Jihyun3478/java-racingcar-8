package racingcar.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceIntegrationTest {

    @Test
    @DisplayName("랜덤값을 고정해 전체 경주 로직의 흐름을 검증한다.")
    void 랜덤값_고정_통합_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = Cars.from("pobi,woni,jun");

                    cars.moveAll();

                    assertThat(cars.getCars())
                            .extracting(Car::getName)
                            .containsExactly("pobi", "woni", "jun");

                    assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                    assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
                    assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);

                    cars.moveAll();

                    assertThat(cars.getCars().get(0).getPosition()).isEqualTo(2);
                    assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
                    assertThat(cars.getCars().get(2).getPosition()).isEqualTo(1);

                    assertThat(cars.findWinners()).containsExactly("pobi");
                },
                4, 3, 4,
                5, 4, 3
        );
    }

    @Test
    @DisplayName("공동 우승을 검증한다.")
    void 공동_우승_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    Cars cars = Cars.from("pobi,woni");
                    TrialCount trialCount = new TrialCount(3);

                    for (int i = 0; i < trialCount.trialCount(); i++) {
                        cars.moveAll();
                    }

                    assertThat(cars.findWinners()).containsExactly("pobi", "woni");
                    assertThat(cars.getCars().get(0).getPosition()).isEqualTo(3);
                    assertThat(cars.getCars().get(1).getPosition()).isEqualTo(3);
                },
                4, 4,
                4, 4,
                4, 4
        );
    }
}
