package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.Constants;
import pairmatching.constants.Message;
import pairmatching.domain.Mission;
import pairmatching.domain.Menu;

public class InputView {

	public static Menu inputSelectMenu() {
		return new Menu(input());
	}

	private static String input() {
		return Console.readLine();
	}

	public static Mission inputMatchingInformation() {
		return new Mission(input());
	}

	public static Boolean inputReMatchingOrNot() {
		String input = input();
		if (!isValidInputReMatchingOrNot(input)) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_INPUT_REMATCHING_OR_NOT);
		}
		if (input.equals(Constants.NO)) {
			return false;
		}
		return true;
	}

	private static boolean isValidInputReMatchingOrNot(String input) {
		return input.equals(Constants.YES) || input.equals(Constants.NO);
	}
}
