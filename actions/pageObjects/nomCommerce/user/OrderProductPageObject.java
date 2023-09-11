package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.OrderProductPageUI;
import PageUIs.nopcommerce.user.RecentlyViewProductPageUI;
import commons.BasePage;

public class OrderProductPageObject extends BasePage {
	WebDriver driver;

	public OrderProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToDetailsOrder() {
		waitForElementClickable(driver, OrderProductPageUI.BUTTON_DETAILS_ORDER);
		clickToElement(driver, OrderProductPageUI.BUTTON_DETAILS_ORDER);
	}

}
