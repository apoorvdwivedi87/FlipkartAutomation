package org.flipkart.Pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.flipkart.base.BasePage;
import org.flipkart.browserFactory.BrowserFactory;
import org.flipkart.webElementExtension.BrowserControls;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	

	private String headerMenuItem;

	@FindBy(how = How.XPATH, using = "//div[@class='_1psGvi _3BvnxG']")
	private WebElement userProfile;

	@FindBy(how = How.CSS, using = "div.ZEl_b_ _1J9ow0 _2ogGYG _23xUYh _3pAV4E")
	private WebElement profileMenu;

	@FindBy(how = How.XPATH, using = "//ul[@class='pO9syL undefined']//div[@class='_3vhnxf']")
	private List<WebElement> profileMenuItems;

	@FindBy(how = How.XPATH, using = "//div[@class='_2Xfa2_']/div")
	private List<WebElement> headersHomePage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_37M3Pb']/div")
	private List<WebElement> list_headersHomePage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_1YokD2 _2GoDe3']//a[@class='_2KpZ6l _3dESVI']")
	private WebElement link_dealOfTheDay;
	
	
	/**
	 * Method to mouse hover on profileMenu
	 */
	public void navigateOnUserProfile() {
		BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), userProfile);
	}

	/**
	 * Method to mouse hover on Profile
	 */
	public void mouseHoverOnProfileMenu() {
		WebElement element = null;
		try {
			element = BrowserFactory.getWebDriver().findElement(By.xpath("//ul[@class='pO9syL undefined']"));
			BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), element);
		} catch (NoSuchElementException e) {
			navigateOnUserProfile();
			element = BrowserFactory.getWebDriver().findElement(By.xpath("//ul[@class='pO9syL undefined']"));
			BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), element);
		}
	}

	/**
	 * Checks if the element required is present in Profile menu list
	 * 
	 * @param String
	 * @return boolean
	 */
	public boolean menuItemIsPresent(String menuItem) {
		int countOfWebElement = (int) profileMenuItems.stream()
				.filter(webElement -> webElement.getText().equalsIgnoreCase(menuItem)).count();
		if (countOfWebElement > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method return WebElement of the matching header
	 * @param headerItem
	 * @return
	 */
	private int getHeaderItem(String headerItem) {
		WebElement headerElement =   list_headersHomePage.stream().filter(webElement -> webElement.getText()
									 .equalsIgnoreCase(headerItem)).findFirst().get();
		int elementIndex = list_headersHomePage.indexOf(headerElement);
		assertTrue(elementIndex > 0 , headerItem + "  is not present");
		return elementIndex+1; 
	}
	
	/**
	 * Method to move to gaming menu
	 * @param headerName
	 * @throws InterruptedException 
	 */
	public void moveToMainHeaderMenu(String headerName) {
		int headerItem = getHeaderItem(headerName);
		headerMenuItem = "//div[@class='_37M3Pb']/div[" + headerItem +"]";
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getWebDriver(),10);
		wait.until(ExpectedConditions.stalenessOf(BrowserFactory.getWebDriver().findElement(By.xpath(headerMenuItem))));
		WebElement headerElement = BrowserFactory.getWebDriver().findElement(By.xpath(headerMenuItem));
		BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), headerElement);
	}
	
	/**
	 * This method clicks on the sub menu item of the main header
	 */
	public void moveToSubMenuItem(String subMenuItemName) {
		String subMenuXPath = headerMenuItem + "//div[@class='_1psGvi SLyWEo']//div[@class='_2IjXr8']//div[@class='_3XS_gI _7qr1OC']/a";
		List<WebElement> subMenuItems = BrowserFactory.getWebDriver().findElements(By.xpath(subMenuXPath));
		assertTrue(subMenuItems.size() > 0 , "Submenu item list is empty");
		WebElement subMenuItem  = subMenuItems.stream().filter(webElement -> webElement.getText()
									.equalsIgnoreCase(subMenuItemName)).findAny().get();
		BrowserControls.moveMouseOn(BrowserFactory.getWebDriver(), subMenuItem);
		BrowserControls.clickOnElement(subMenuItem);
	}
	
	/**
	 * Click on the link Deal of the day
	 * @throws InterruptedException
	 */
	public DealOfTheDayPage clickOnLinkOfTheDayDeal() throws InterruptedException {
		headerMenuItem = "//div[@class='_37M3Pb']/div[" + 5 +"]";
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getWebDriver(),10);
		wait.until(ExpectedConditions.stalenessOf(BrowserFactory.getWebDriver().findElement(By.xpath(headerMenuItem))));
		BrowserControls.clickOnElement(link_dealOfTheDay);
		return GetInstanceOf(DealOfTheDayPage.class);
	}
}
