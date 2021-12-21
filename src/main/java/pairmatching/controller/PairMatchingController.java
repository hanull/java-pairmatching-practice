package pairmatching.controller;

import pairmatching.domain.Crews;
import pairmatching.domain.Menu;
import pairmatching.utils.FileUploadUtils;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		Crews crews = FileUploadUtils.initializeCrews();
		Menu menu = selectMainMenu();

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
