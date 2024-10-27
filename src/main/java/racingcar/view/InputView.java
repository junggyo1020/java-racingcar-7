package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.TrialCountValidator;

/**
 * InputView
 * - 사용자 입력 관리
 */
public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public static int getTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int trialCount = Integer.parseInt(Console.readLine());
        TrialCountValidator.validate(trialCount);
        return trialCount;
    }
}
