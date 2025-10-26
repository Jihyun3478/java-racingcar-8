package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.service.RaceService;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new RaceService());
        raceController.run();
    }
}
