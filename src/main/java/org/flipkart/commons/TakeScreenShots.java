package org.flipkart.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShots {

	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		String format = dateFormat.format(date);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/"+format+"/" + screenShotName + format + ".png";
		File finalDest = new File(destination);
		FileUtils.copyFile(source, finalDest);
		return destination;

	}

}
