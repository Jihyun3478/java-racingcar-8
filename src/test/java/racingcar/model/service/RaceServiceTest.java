package racingcar.model.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.TrialCount;

public class RaceServiceTest {
    private RaceService raceService;
    private Cars cars;
    private TrialCount trialCount;

    @BeforeEach
    void setUp() {
        cars = Cars.from("pobi,woni,jun");
        trialCount = new TrialCount(3);
        raceService = new RaceService();
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승한다.")
    public void 가장_많이_전진한_자동차가_우승() {
        List<String> winners = raceService.start(cars, trialCount);

        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}
