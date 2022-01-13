package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import pairmatching.constants.Message;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", Collections.emptyList()),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", Collections.emptyList());

	private String name;
	private List<String> missions;

	Level(String name, List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static Level fromName(String levelName) {
		return Stream.of(Level.values())
			.filter(level -> level.name.equals(levelName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.ERROR_NOT_FOUND_LEVEL));
	}

	public static boolean isFindLevel(String levelName) {
		return Stream.of(Level.values())
			.anyMatch(level -> level.name.equals(levelName));
	}

	public static boolean isFindMission(String levelName, String missionName) {
		List<String> missions = Stream.of(Level.values())
			.filter(level -> level.name.equals(levelName))
			.findFirst()
			.map(level -> level.missions)
			.get();
		return missions.stream()
			.anyMatch(mission -> mission.equals(missionName));
	}
}