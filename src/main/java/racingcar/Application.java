package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Cars cars = new Cars(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        TrialCount trialCount = getTrialCount();
    }

    private static TrialCount getTrialCount() {
        int trialCount = 0;
        try {
            String inputTrialCount = Console.readLine();
            if (Objects.isNull(inputTrialCount) || inputTrialCount.trim().isEmpty()) {
                throw new IllegalArgumentException("입력이 빈 값입니다.");
            }
            trialCount = Integer.parseInt(inputTrialCount);
            return new TrialCount(trialCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자이어야 합니다.");
        }
    }
}
