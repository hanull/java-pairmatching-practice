package pairmatching;

import pairmatching.controller.PairMatchingController;

public class Application {
	public static void main(String[] args) {
		PairMatchingController mainController = new PairMatchingController();
		mainController.run();
	}
}
