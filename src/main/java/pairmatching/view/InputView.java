package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Menu;

public class InputView {

	public static Menu inputSelectMenu() {
		return new Menu(input());
	}

	private static String input() {
		return Console.readLine();
	}
}
