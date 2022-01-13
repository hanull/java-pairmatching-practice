package pairmatching.view;

import java.util.List;

import pairmatching.constants.Constants;
import pairmatching.constants.Message;
import pairmatching.domain.Pair;

public class OutputView {

	public static void printException(Exception exception) {
		System.out.println(Constants.ERROR + exception.getMessage());
	}

	public static void printSelectMainMenu() {
		System.out.println(Message.MAIN_MENU);
	}

	public static void printInputMatchingInformation() {
		printNewLine();
		System.out.println(Message.INPUT_MATCHING_INFORMATION);
	}

	private static void printNewLine() {
		System.out.println();
	}

	public static void printPairs(List<Pair> pairs) {
		for (Pair pair : pairs) {
			System.out.println(pair);
		}
		printNewLine();
	}

	public static void printReMatchingOrNot() {
		System.out.println(Message.INPUT_REMATCHING_OR_NOT);
	}
}
