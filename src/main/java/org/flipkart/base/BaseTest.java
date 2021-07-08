package org.flipkart.base;

import org.flipkart.browserFactory.BrowserFactory;
import org.flipkart.commons.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Base {

	@BeforeMethod
	public void appInitialization() {
		BrowserFactory.initDriver(Settings.browserName);
	}

	@AfterMethod
	public void testTearDown() {
		BrowserFactory.getWebDriver().quit();
	}
}
