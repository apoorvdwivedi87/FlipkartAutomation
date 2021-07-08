package org.flipkart.retryFailedTests;

import org.flipkart.commons.Settings;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (Settings.retryFailedTests.equalsIgnoreCase("true") && count < retryLimit) {
			count++;
			return true;
		}
		return false;
	}
}
