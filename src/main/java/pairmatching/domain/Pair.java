package pairmatching.domain;

import pairmatching.constants.Constants;

public class Pair {

	private String navigator;
	private String driver;

	public Pair(String navigator, String driver) {
		this.navigator = navigator;
		this.driver = driver;
	}

	public boolean isSame(Pair newPair) {
		return (navigator.equals(newPair.getNavigator()) && driver.equals(newPair.getDriver())) ||
			(driver.equals(newPair.getNavigator()) && navigator.equals(newPair.getDriver()));
	}

	public String getNavigator() {
		return navigator;
	}

	public String getDriver() {
		return driver;
	}

	@Override
	public String toString() {
		String output = navigator + Constants.COLON;
		String[] splitDriver = driver.split(Constants.BLANK);
		output += splitDriver[0];
		if (splitDriver.length == 2) {
			output += Constants.COLON + splitDriver[1];
		}
		return output;
	}
}
