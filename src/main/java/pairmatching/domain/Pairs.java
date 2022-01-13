package pairmatching.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pairs {

	private final Map<Mission, List<Pair>> pairs;

	public Pairs(Map<Mission, List<Pair>> pairs) {
		this.pairs = pairs;
	}

	public boolean usedToBeSameTeam(Pair newPair, Course course, Level level) {
		List<Mission> missions = getMissions(course, level);
		for (Mission mission : missions) {
			if (checkSamePair(newPair, mission)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkSamePair(Pair newPair, Mission mission) {
		for (Pair pair : pairs.get(mission)) {
			if (pair.isSame(newPair)) {
				return true;
			}
		}
		return false;
	}

	private List<Mission> getMissions(Course course, Level level) {
		return pairs.keySet().stream()
			.filter(mission -> mission.getCourse().equals(course) &&
				mission.getLevel().equals(level))
			.collect(Collectors.toList());
	}

	public void add(Mission mission, List<Pair> newPairs) {
		pairs.put(mission, newPairs);
	}

	public boolean isAlreadyMatching(Mission mission) {
		return pairs.containsKey(mission);
	}

	public List<Pair> getPairs(Mission mission) {
		return pairs.get(mission);
	}

	public void initialize() {
		pairs.clear();
	}
}
