package org.flipkart.browserFactory;

import java.util.concurrent.TimeUnit;

import org.flipkart.commons.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	
	
	protected static  ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	/** 
	 * This method takes browser name as input
	 * and initiates webdriver
	 **/
	public static void initDriver(String browserName) {

		switch (browserName) {
		case "Chrome":
			initChromeDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * This method initializes the chrome driver 
	 **/
	private static synchronized void initChromeDriver() {

		String dirPath = System.getProperty("user.dir");
		String driverPath = dirPath.concat("/Drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		if(Settings.headLess.equalsIgnoreCase("true")) {
			options.addArguments("headless");
		}
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		threadLocalDriver.set(driver);
	}

	/**
	 * This method returns driver instance
	 **/
	public static synchronized WebDriver getWebDriver() {
		return threadLocalDriver.get();
	}

}
