package org.flipkart.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flipkart.commons.Settings;


public class Logs {

	
	private static  Logger Log = LogManager.getLogger(Logs.class.getName());
	
	public static void info(String message) {
		
		if(Settings.logs.equalsIgnoreCase("true")) {
			Log.info(message);
		}
		
	}
	
	public static void error(String message) {
		
		if(Settings.logs.equalsIgnoreCase("true")) {
			Log.error(message);
		}
		
	}
	
	public static void debug(String message) {
		
		if(Settings.logs.equalsIgnoreCase("true")) {
			Log.debug(message);
		}
		
		
	}
}
