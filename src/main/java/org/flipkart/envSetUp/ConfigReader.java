package org.flipkart.envSetUp;

import org.flipkart.commons.Settings;

public class ConfigReader {
	
	
	
	/**  
	 * This method sets the setting configuration by reading properties file
	 **/
	public static void setConfigSettings() {
		
		Settings.configProp =  Settings.appUtil.propFileReader(Settings.propFilePath);
		
		Settings.browserName = Settings.configProp.getProperty("browserName");
		
		Settings.URL = Settings.configProp.getProperty("appUrl");
		
		Settings.userName = Settings.configProp.getProperty("userName");
		
		Settings.password = Settings.configProp.getProperty("password");
		
		Settings.headLess = Settings.configProp.getProperty("headLess");
		
		Settings.failedScreenShots = Settings.configProp.getProperty("failedScreenShots");
		
		Settings.logs = Settings.configProp.getProperty("logs");
		
		Settings.retryFailedTests = Settings.configProp.getProperty("retryFailedTests");
		
		Settings.extentReport = Settings.configProp.getProperty("extentReport");
		
	}
	
	
}
