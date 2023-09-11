package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.AdvancedSearchUI;
import commons.BasePage;

public class AdvancedSearchPageObject extends BasePage {
	WebDriver driver;

	public AdvancedSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonSearch() {
		waitForElementVisible(driver, AdvancedSearchUI.BUTTON_SEARCH);
		clickToElement(driver, AdvancedSearchUI.BUTTON_SEARCH);

	}

	public String getErrorMessageMinimumLength() {
		waitForElementVisible(driver, AdvancedSearchUI.ERROR_MESSAGE_LESS_3_CHARACTERS);
		return getTextElement(driver, AdvancedSearchUI.ERROR_MESSAGE_LESS_3_CHARACTERS);

	}

	public void inputToSearch(String valueData) {
		waitForElementVisible(driver, AdvancedSearchUI.TEXTBOX_SEARCH_KEYWORD);
		sendKeysToElement(driver, AdvancedSearchUI.TEXTBOX_SEARCH_KEYWORD, valueData);

	}

	public String getNotFoundProducts() {
		waitForElementVisible(driver, AdvancedSearchUI.NOT_FOUND_PRODUCTS);
		return getTextElement(driver, AdvancedSearchUI.NOT_FOUND_PRODUCTS);
	}

	public boolean isdisplayProductsWithText(String textValue) {
		waitForElementVisible(driver, AdvancedSearchUI.ISDISPLAY_PRODUCTS_WITH_TEXT, textValue);
		return isElementDisplayd(driver, AdvancedSearchUI.ISDISPLAY_PRODUCTS_WITH_TEXT, textValue);
	}

	public void clickToCheckboxBylabel(String label) {
		waitForElementClickable(driver, AdvancedSearchUI.CHECKBOX_BY_LABEL, label);
		checkToDefaultCheckBoxRadio(driver, AdvancedSearchUI.CHECKBOX_BY_LABEL, label);

	}

	public void selectBylabel(String label, String value) {
		waitForElementVisible(driver, AdvancedSearchUI.SELECT_BY_LABEL, label);
		selectItemInDefaultDropDown(driver, AdvancedSearchUI.SELECT_BY_LABEL, value, label);

	}
}
