package org.flipkart.base;

import org.flipkart.browserFactory.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class Base {

	
	
	public BasePage CurrentPage;

	public  <TPage extends BasePage> TPage GetInstanceOf(Class<TPage> page) {

		Object obj = PageFactory.initElements(BrowserFactory.getWebDriver(), page);
		return page.cast(obj);
	}

}
