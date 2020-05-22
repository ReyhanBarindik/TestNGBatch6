package com.syntax.utils;

public class Constants {

	// whole the value and we do not want to change

	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

	public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";

	public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir")+ "\\configs\\configuration.properties";

	public static final int IMPLICIT_WAIT_TIME = 15;

	public static final int EXPLICIT_WAIT_TIME = 30;
}
