package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.RecentlyViewProductPageUI;
import commons.BasePage;

public class RecentlyViewProductPageObject extends BasePage {
	WebDriver driver;

	public RecentlyViewProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getSizeItem() {
		waitForElementVisible(driver, RecentlyViewProductPageUI.ITEM_BOX);
		return getElementSize(driver, RecentlyViewProductPageUI.ITEM_BOX);

	}

}
