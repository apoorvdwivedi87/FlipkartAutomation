package org.flipkart.webElementExtension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BrowserControls {

	
	
	public static void clickOnElement(WebElement element) {
		
		element.click();
	}
	
	public static void enterText(WebElement element , String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	public static void moveMouseOn( WebDriver driver , WebElement element ) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
}
