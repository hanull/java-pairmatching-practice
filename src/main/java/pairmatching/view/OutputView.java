package pairmatching.view;

public class OutputView {

	private static final String ERROR = "[ERROR] ";
	private static final String MAIN_MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";

	public static void printException(Exception exception) {
		System.out.println(ERROR + exception.getMessage());
	}

	public static void printSelectMainMenu() {
		System.out.println(MAIN_MENU);
	}
}
