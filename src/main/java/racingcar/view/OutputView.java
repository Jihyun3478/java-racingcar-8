package racingcar.view;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Cars;

public class OutputView {
    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void promptRaceState() {
        System.out.println("\n실행 결과");
    }



    public static void promptWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
