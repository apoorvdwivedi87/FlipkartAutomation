package org.flipkart.Pages;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.flipkart.base.BasePage;
import org.flipkart.browserFactory.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DealOfTheDayPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='CXW8mj']/img")
	private List<WebElement> images_DOTDproducts;

	@FindBy(how = How.XPATH, using = "//div[@class='_1Yt2GF']")
	private WebElement header_DealOfTheDay;

	/***
	 * Validates if all products has images present
	 */
	public void validateAllProductsHasImages() {

		assertTrue(header_DealOfTheDay.isDisplayed());
		List<Boolean> imagesPresent = new ArrayList<>();
		for (WebElement webElement : images_DOTDproducts) {
			Boolean bool = validateImageIsPresent(webElement);
			imagesPresent.add(bool);
		}
		assertTrue(images_DOTDproducts.size() == imagesPresent.size(), "All images are not present");
	}

	/***
	 * Method to check if image is present for a particular webelement
	 * 
	 * @param imageFile
	 * @return
	 */
	private Boolean validateImageIsPresent(WebElement imageFile) {
		WebDriver driver = BrowserFactory.getWebDriver();
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				imageFile);
		return ImagePresent;
	}

}
