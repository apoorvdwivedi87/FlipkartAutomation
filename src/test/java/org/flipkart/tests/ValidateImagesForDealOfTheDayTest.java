package org.flipkart.tests;

import org.flipkart.Pages.ApplicationLoginPage;
import org.flipkart.Pages.DealOfTheDayPage;
import org.flipkart.Pages.HomePage;
import org.flipkart.base.BaseTest;
import org.testng.annotations.Test;

public class ValidateImagesForDealOfTheDayTest extends BaseTest {

	/**
	 * Validates if the images are present for all the items present on deals of the
	 * day page
	 * 
	 * @throws InterruptedException
	 */

	@Test
	public void validateImagesArePresentForAllTheDealOfTheDayItems() throws InterruptedException {

		CurrentPage = GetInstanceOf(ApplicationLoginPage.class);
		CurrentPage = CurrentPage.As(ApplicationLoginPage.class).LoginApplication();
		CurrentPage = CurrentPage.As(HomePage.class).clickOnLinkOfTheDayDeal();
		CurrentPage.As(DealOfTheDayPage.class).validateAllProductsHasImages();
	}

}
