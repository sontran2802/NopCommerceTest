package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminCustomersPageUI;
import PageUIs.nopcommerce.admin.AdminDashboardPageUI;
import commons.BasePage;

public class AdminCustomersPageObject extends BasePage {
	private WebDriver driver;

	public AdminCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonAddNew() {
		waitForElementClickable(driver, AdminCustomersPageUI.BUTTON_TO_ADD_NEW);
		clickToElement(driver, AdminCustomersPageUI.BUTTON_TO_ADD_NEW);
		sleepInSecond(1);

	}

	public void inputSearchByLabel(String label, String value) {
		waitForElementVisible(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		clearToInput(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		sendKeysToElement(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, value, label);

	}

}
