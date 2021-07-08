package org.flipkart.tests;

import org.flipkart.Pages.ApplicationLoginPage;
import org.flipkart.Pages.HomePage;
import org.flipkart.base.BaseTest;
import org.testng.annotations.Test;

public class ValidateGamesSubMenuTest extends BaseTest {

	@Test
	public void validateGamesUnderElectronicSection() throws InterruptedException {

		CurrentPage = GetInstanceOf(ApplicationLoginPage.class);
		CurrentPage = CurrentPage.As(ApplicationLoginPage.class).LoginApplication();
		CurrentPage.As(HomePage.class).moveToMainHeaderMenu("Electronics");
		CurrentPage.As(HomePage.class).moveToSubMenuItem("Gaming");
	}

}
