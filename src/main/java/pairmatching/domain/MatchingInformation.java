package pairmatching.domain;

import pairmatching.constants.Constants;
import pairmatching.constants.Message;

public class MatchingInformation {

	private Course course;
	private Level level;
	private String mission;

	public MatchingInformation(String inputInformation) {
		String[] information = inputInformation.split(Constants.COMMA);
		validateInputInformation(information);
		this.course = Course.fromName(trimString(information[0]));
		this.level = Level.fromName(trimString(information[1]));
		this.mission = trimString(information[2]);
	}

	private String trimString(String information) {
		return information.replaceAll(" ", "").trim();
	}

	private void validateInputInformation(String[] information) {
		if (!isValidInformation(information.length)) {
			throw new IllegalArgumentException(Message.ERROR_INVALID_INFORMATION_INPUT_TYPE);
		}
		if (!isFindCourse(trimString(information[0]))) {
			throw new IllegalArgumentException(Message.ERROR_NOT_FOUND_COURSE);
		}
		if (!isFindLevel(trimString(information[1]))) {
			throw new IllegalArgumentException(Message.ERROR_NOT_FOUND_LEVEL);
		}
		if (!isFindMission(trimString(information[1]), trimString(information[2]))) {
			throw new IllegalArgumentException(Message.ERROR_NOT_FOUND_MISSION);
		}
	}

	private boolean isFindMission(String level, String mission) {
		return Level.isFindMission(level, mission);
	}

	private boolean isFindLevel(String level) {
		return Level.isFindLevel(level);
	}

	private boolean isFindCourse(String course) {
		return Course.isFindCourse(course);
	}

	private boolean isValidInformation(int length) {
		return length == Constants.INFORMATION_LENGTH;
	}
}
