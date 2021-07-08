package org.flipkart.tests;

import static org.testng.Assert.assertTrue;

import org.flipkart.Pages.ApplicationLoginPage;
import org.flipkart.Pages.HomePage;
import org.flipkart.base.BaseTest;
import org.testng.annotations.Test;

public class ValidateUserLoginTest extends BaseTest {

	@Test
	public void userIsAbleToLoginSuccsfully() throws InterruptedException {
		CurrentPage = GetInstanceOf(ApplicationLoginPage.class);
		CurrentPage = CurrentPage.As(ApplicationLoginPage.class).LoginApplication();
		CurrentPage.As(HomePage.class).navigateOnUserProfile();
		CurrentPage.As(HomePage.class).mouseHoverOnProfileMenu();
		boolean bool = CurrentPage.As(HomePage.class).menuItemIsPresent("Logout");
		assertTrue(bool, "Logout option is not visible , user is not loged in");
	}

}
