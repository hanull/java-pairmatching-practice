package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.Menu;

public class InputView {

	public static Menu inputSelectMenu() {
		return new Menu(input());
	}

	private static String input() {
		return Console.readLine();
	}

	public static MatchingInformation inputMatchingInformation() {
		return new MatchingInformation(input());
	}
}
