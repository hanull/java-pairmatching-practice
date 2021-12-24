package pairmatching.controller;

import pairmatching.constants.Constants;
import pairmatching.domain.Crews;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.Menu;
import pairmatching.utils.FileUploadUtils;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		Crews crews = FileUploadUtils.initializeCrews();
		while (true) {
			Menu menu = selectMainMenu();
			if (menu.isQuit()) {
				break;
			}
			controlMenu(menu);
		}
	}

	private void controlMenu(Menu menu) {
		if (menu.isPairMatching()) {
			pairMatching();
		}
		if (menu.findPair()) {

		}
		if (menu.initializePair()) {

		}
	}

	private void pairMatching() {
		try {
			int pairMatchingCount = 0;
			while (pairMatchingCount < Constants.MAX_PAIR_MATCHING_COUNT) {
				MatchingInformation matchingInformation = inputMatchingInformation();
			}
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
		}
	}

	private MatchingInformation inputMatchingInformation() {
		try {
			OutputView.printInputMatchingInformation();
			return InputView.inputMatchingInformation();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return inputMatchingInformation();
		}
	}

	private Menu selectMainMenu() {
		try {
			OutputView.printSelectMainMenu();
			return InputView.inputSelectMenu();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return selectMainMenu();
		}
	}
}
