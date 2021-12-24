package pairmatching.domain;

import java.util.stream.Stream;

import pairmatching.constants.Message;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드");

	private String name;

	Course(String name) {
		this.name = name;
	}

	public static Course fromName(String name) {
		return Stream.of(Course.values())
			.filter(course -> course.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.ERROR_NOT_FOUND_COURSE));
	}

	public static boolean isFindCourse(String name) {
		return Stream.of(Course.values())
			.anyMatch(course -> course.name.equals(name));
	}
}