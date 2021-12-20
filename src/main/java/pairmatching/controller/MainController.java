package pairmatching.controller;

import pairmatching.domain.Crews;
import pairmatching.utils.FileUploadUtils;

public class MainController {

	public void run() {
		Crews crews = FileUploadUtils.initializeCrews();

	}
}
