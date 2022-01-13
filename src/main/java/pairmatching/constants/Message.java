package pairmatching.constants;

public final class Message {
	public static final String ERROR_INVALID_MENU = "위의 기능 중 하나를 선택해주세요.";
	public static final String INPUT_MATCHING_INFORMATION = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n"
		+ "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	public static final String MAIN_MENU = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";

	public static final String ERROR_NOT_FOUND_COURSE = "해당 과정을 찾을 수 없습니다.";
	public static final String ERROR_NOT_FOUND_LEVEL = "해당 레벨을 찾을 수 없습니다.";
	public static final String ERROR_INVALID_INFORMATION_INPUT_TYPE = "과정, 레벨, 미션 형식으로 입력해주세요.";
	public static final String ERROR_NOT_FOUND_MISSION = "해당 미션을 찾을 수 없습니다.";
	public static final String ERROR_IMPOSSIBLE_MATCHING = "매칭에 실패했습니다.";
	public static final String INPUT_REMATCHING_OR_NOT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";
	public static final String ERROR_INVALID_INPUT_REMATCHING_OR_NOT = "\"네\", \"아니오\"로 대답해주세요.";
}
