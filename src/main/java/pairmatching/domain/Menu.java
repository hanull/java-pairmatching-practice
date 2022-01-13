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

	public boolean isQuit() {
		return menu.equals(Constants.QUIT);
	}

	public boolean isPairMatching() {
		return menu.equals(Constants.PAIR_MATCHING);
	}

	public boolean findPair() {
		return menu.equals(Constants.FIND_PAIR);
	}

	public boolean initializePair() {
		return menu.equals(Constants.INITIALIZE_PAIR);
	}
}
