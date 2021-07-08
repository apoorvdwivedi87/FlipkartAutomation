package org.flpkart.extentReportManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.flipkart.commons.Settings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {

	private ExtentReports extent;

	public  ExtentReports initExtentReports() {
		if(Settings.extentReport.equalsIgnoreCase("true")) {
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(getExtentReportPath());
			extent = new ExtentReports();
			extent.attachReporter(sparkreporter);
		}
		
		return extent;
	}

	private File getExtentReportPath() {

		String userDir = System.getProperty("user.dir");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String format = dateFormat.format(date);
		String filePath = userDir + "/ExtentReports/" + format + "/" + "extent.html";
		File dir = new File(filePath);
		dir.mkdir();
		return dir;

	}

}
