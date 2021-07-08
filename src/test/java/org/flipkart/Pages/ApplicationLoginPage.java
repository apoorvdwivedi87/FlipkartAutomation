package org.flipkart.Pages;

import org.flipkart.base.BasePage;
import org.flipkart.commons.Settings;
import org.flipkart.launchApp.LaunchApplication;
import org.flipkart.webElementExtension.BrowserControls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ApplicationLoginPage extends BasePage {

	

	@FindBy(how = How.XPATH , using = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement txtBx_UserName;
	
	@FindBy(how = How.XPATH,using = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement txtBx_Password;
	
	@FindBy(how = How.XPATH , using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement btn_Login;
	
	
	
	
	
	public HomePage LoginApplication() {
		
		LaunchApplication launchApp = new LaunchApplication();
		launchApp.openUrl();
		enterUserName(Settings.userName);
		enterPassword(Settings.password);
		clickOnLoginBtn();
		return GetInstanceOf(HomePage.class);
		
	}
	
	private void enterUserName(String userName) {
		 BrowserControls.enterText(txtBx_UserName, userName);
	}
	
	private void enterPassword(String password) {
		BrowserControls.enterText(txtBx_Password, password);
	}
	
	private void clickOnLoginBtn() {
		BrowserControls.clickOnElement(btn_Login);
	}
	
	
	
	
	
}
