package org.flipkart.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

public class AppUtilities {

	/** 
	 * This method is used to read the properties file
	 **/
	public Properties propFileReader(String filePath) {

		Properties prop = new Properties();
		try {
				InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
				prop.load(inputStream);

		} catch (IOException exceptiopn) {

			Assert.assertFalse(true, "File not found");
		}
		return prop;
	}

}
