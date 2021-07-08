package org.flipkart.launchApp;

import org.flipkart.browserFactory.BrowserFactory;
import org.flipkart.commons.Settings;

public class LaunchApplication {

	
	public void openUrl() {
		BrowserFactory.getWebDriver().get(Settings.URL);
	}
	
	
	
}
