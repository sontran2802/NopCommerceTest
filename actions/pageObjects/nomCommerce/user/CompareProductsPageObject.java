package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.CompareProductPageUI;
import commons.BasePage;

public class CompareProductsPageObject extends BasePage {
	WebDriver driver;

	public CompareProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCompareProductByLabel(String label) {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_TABLE_BY_LABEL, label);
		return isElementDisplayd(driver, CompareProductPageUI.COMPARE_TABLE_BY_LABEL, label);

	}

	public void clickToButtonClearList() {
		waitForElementClickable(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);

	}

	public String getNoDataCompare() {
		waitForElementVisible(driver, CompareProductPageUI.NO_ITEM_TO_COMPARE);
		return getTextElement(driver, CompareProductPageUI.NO_ITEM_TO_COMPARE);
	}

}
