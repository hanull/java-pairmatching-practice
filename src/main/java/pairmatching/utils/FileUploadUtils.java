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

	public static Crews initializeCrews() {
		try {
			List<Crew> crews = new ArrayList<>();
			FileReader backendFile = new FileReader(BACKEND_FILE);
			FileReader frontendFile = new FileReader(FRONTEND_FILE);
			addCrews(new BufferedReader(frontendFile), crews, Course.FRONTEND);
			addCrews(new BufferedReader(backendFile), crews, Course.BACKEND);
			return new Crews(crews);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void addCrews(BufferedReader crewsBuffered, List<Crew> crews, Course frontend) throws IOException {
		String name;
		while ((name = crewsBuffered.readLine()) != null) {
			crews.add(new Crew(frontend, name));
		}
	}
}
