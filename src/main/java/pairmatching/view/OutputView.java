package pairmatching.view;

import pairmatching.constants.Constants;
import pairmatching.constants.Message;

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
}
