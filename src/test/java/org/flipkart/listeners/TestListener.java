package org.flipkart.listeners;

import java.io.IOException;
import org.flipkart.browserFactory.BrowserFactory;
import org.flipkart.commons.Settings;
import org.flipkart.commons.TakeScreenShots;
import org.flipkart.log.Logs;
import org.flpkart.extentReportManager.ExtentFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {

	private ExtentFactory extentFactory;
	private ExtentReports extent;
	private ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		if (Settings.extentReport.equalsIgnoreCase("true")) {
			extentFactory = new ExtentFactory();
			extent = extentFactory.initExtentReports();
		}
		if (Settings.logs.equalsIgnoreCase("true")) {
			Logs.info("Extent report had been initiated");
		}

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (Settings.extentReport.equalsIgnoreCase("true")) {
			test = extent.createTest(result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}

		if (Settings.logs.equalsIgnoreCase("true")) {
			Logs.info(result.getName() + " Passed ");
		}

	}

	public void onTestFailure(ITestResult result) {

		if (Settings.extentReport.equalsIgnoreCase("true")) {
			test = extent.createTest(result.getName());
			if (result.getStatus() == ITestResult.FAILURE) {
				test.fail(result.getThrowable());
				String screenShotPath = null;
				try {
					screenShotPath = TakeScreenShots.getScreenShot(BrowserFactory.getWebDriver(), result.getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
				test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}
		}

		if (Settings.logs.equalsIgnoreCase("true")) {
			Logs.info(result.getName() + " Failed ");
		}
		
		if(Settings.failedScreenShots.equalsIgnoreCase("true")) {
			String screenShotPath = null;
			try {
				screenShotPath = TakeScreenShots.getScreenShot(BrowserFactory.getWebDriver(), result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		if (Settings.extentReport.equalsIgnoreCase("true")) {
			extent.flush();
		}

		if (Settings.logs.equalsIgnoreCase("true")) {
			Logs.info(context.getName());
		}
	}
}
