package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race(new Cars("pobi,woni,jun"), new TrialCount(3));
        race.start();
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 우승한다.")
    public void 가장_많이_전진한_자동차가_우승() {
        List<String> winners = race.judgeWinners();

        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}
