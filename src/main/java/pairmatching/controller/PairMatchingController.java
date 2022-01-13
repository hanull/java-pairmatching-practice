package pairmatching.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constants.Constants;
import pairmatching.constants.Message;
import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Mission;
import pairmatching.domain.Menu;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.utils.FileUploadUtils;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private final Crews frontendCrews;
	private final Crews backendCrews;
	private final Pairs pairs;

	public PairMatchingController() {
		this.frontendCrews = FileUploadUtils.initializeFrontendCrews();
		this.backendCrews = FileUploadUtils.initializeBackendCrews();
		this.pairs = new Pairs(new HashMap<>());
	}

	public void run() {
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
			Mission mission = inputMatchingInformation();
			if (isAlreadyMatchingPair(mission) && !isAnswerReMatchingOrNot()) {
				return;
			}
			matchPair(mission);
			OutputView.printPairs(pairs.getPairs(mission));
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
		}
	}

	private boolean isAnswerReMatchingOrNot() {
		try {
			OutputView.printReMatchingOrNot();
			return InputView.inputReMatchingOrNot();
		} catch (Exception exception) {
			OutputView.printException(exception);
			return isAnswerReMatchingOrNot();
		}
	}

	private void matchPair(Mission mission) {
		for (int i = 0; i < Constants.AVAILABLE_MATCHING_POINT; i++) {
			List<String> shuffledCrew = Randoms.shuffle(getCrewNames(mission.getCourse()));
			if (isValidShuffle(shuffledCrew, mission)) {
				addPair(shuffledCrew, mission);
				return;
			}
		}
		throw new IllegalArgumentException(Message.ERROR_IMPOSSIBLE_MATCHING);
	}

	private boolean isAlreadyMatchingPair(Mission mission) {
		return pairs.isAlreadyMatching(mission);
	}

	private void addPair(List<String> shuffledCrew, Mission mission) {
		pairs.add(mission, createPairs(shuffledCrew));
	}

	private List<Pair> createPairs(List<String> shuffledCrew) {
		List<Pair> newPairs = new ArrayList<>();
		for (int i = 0; i < shuffledCrew.size(); i += 2) {
			Pair pair = createPair(shuffledCrew, i);
			if (isOddAndLastPair(shuffledCrew, i)) {
				++i;
			}
			newPairs.add(pair);
		}
		return newPairs;
	}

	private boolean isOddAndLastPair(List<String> shuffledCrew, int i) {
		return shuffledCrew.size() % 2 != 0 && i == shuffledCrew.size() - 3;
	}

	private boolean isValidShuffle(List<String> shuffledCrew, Mission mission) {
		for (int i = 0; i < shuffledCrew.size(); i += 2) {
			Pair pair = createPair(shuffledCrew, i);
			if (isOddAndLastPair(shuffledCrew, i)) {
				++i;
			}
			if (pairs.usedToBeSameTeam(pair, mission.getCourse(), mission.getLevel())) {
				return false;
			}
		}
		return true;
	}

	private Pair createPair(List<String> shuffledCrew, int i) {
		String navigator = shuffledCrew.get(i);
		String driver = shuffledCrew.get(i + 1);
		if (isOddAndLastPair(shuffledCrew, i)) {
			driver += Constants.BLANK + shuffledCrew.get(i + 2);
		}
		return new Pair(navigator, driver);
	}

	private List<String> getCrewNames(Course course) {
		if (Course.FRONTEND.equals(course)) {
			return frontendCrews.getNames();
		}
		return backendCrews.getNames();
	}

	private Mission inputMatchingInformation() {
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
