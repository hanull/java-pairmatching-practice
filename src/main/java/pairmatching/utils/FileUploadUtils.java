package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

public class FileUploadUtils {

	private static final String FRONTEND_FILE = "src/main/resources/frontend-crew.md";
	private static final String BACKEND_FILE = "src/main/resources/backend-crew.md";

	public static Crews initializeBackendCrews() {
		return getCrews(BACKEND_FILE, Course.BACKEND);
	}

	public static Crews initializeFrontendCrews() {
		return getCrews(FRONTEND_FILE, Course.FRONTEND);
	}

	private static Crews getCrews(String crewsFile, Course course) {
		try {
			List<Crew> crews = new ArrayList<>();
			FileReader file = new FileReader(crewsFile);
			addCrews(new BufferedReader(file), crews, course);
			return new Crews(crews);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void addCrews(BufferedReader crewsBuffered, List<Crew> crews, Course course) throws IOException {
		String name;
		while ((name = crewsBuffered.readLine()) != null) {
			crews.add(new Crew(course, name));
		}
	}
}
