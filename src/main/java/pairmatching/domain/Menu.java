package pairmatching.domain;

import pairmatching.constants.Constants;
import pairmatching.constants.Message;

public class Menu {

	private final String menu;

	public Menu(String menu) {
		validateInputMenu(menu);
		this.menu = menu;

	}

	private void validateInputMenu(String menu) {
		if (!isValidMenu(menu)) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_MENU);
		}
	}

	private boolean isValidMenu(String menu) {
		return Constants.MENU_LIST.contains(menu);
	}
}
