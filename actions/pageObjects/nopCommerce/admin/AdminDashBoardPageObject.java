package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminDashboardPageUI;
import commons.BasePage;

public class AdminDashBoardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayd(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

	public void clickToSidebarBylabel(String label) {
		waitForElementVisible(driver, AdminDashboardPageUI.LINK_SIDEBAR_BY_LABEL, label);
		clickToElement(driver, AdminDashboardPageUI.LINK_SIDEBAR_BY_LABEL, label);

		sleepInSecond(1);
	}

	public void inputSearchByLabel(String label, String value) {
		waitForElementVisible(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		clearToInput(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		sendKeysToElement(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, value, label);

	}

	public void selectSearchByLabel(String label, String value) {
		waitForElementVisible(driver, AdminDashboardPageUI.SELECT_SEARCH_BY_LABEL, label);
		selectItemInDefaultDropDown(driver, AdminDashboardPageUI.SELECT_SEARCH_BY_LABEL, value, label);

	}

	public void clickButtonSearchProduct() {
		waitForElementClickable(driver, AdminDashboardPageUI.BUTTON_SEARCH_PRODUCT);
		clickToElement(driver, AdminDashboardPageUI.BUTTON_SEARCH_PRODUCT);

	}

	public String getEmptyDataTable() {
		waitForElementVisible(driver, AdminDashboardPageUI.GET_EMPTY_DATA_TABLE);
		return getTextElement(driver, AdminDashboardPageUI.GET_EMPTY_DATA_TABLE);
	}

	public void selectToCheckboxByLabel(String label) {
		waitForElementClickable(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		checkToDefaultCheckBoxRadio(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);

	}

	public void UnSelectToCheckboxByLabel(String label) {
		waitForElementClickable(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		unCheckToDefaultCheckBoxRadio(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);

	}

	public int getSizeProducts() {
		waitForElementVisible(driver, AdminDashboardPageUI.GET_SIZE_PRODUCTS);
		return getElementSize(driver, AdminDashboardPageUI.GET_SIZE_PRODUCTS);

	}

	public String getInfoProduct(String number) {
		waitForElementVisible(driver, AdminDashboardPageUI.GET_TEXT_INFO_PRODUCT, number);
		return getTextElement(driver, AdminDashboardPageUI.GET_TEXT_INFO_PRODUCT, number);
	}

	public void clickToButtonGoSKU() {
		waitForElementClickable(driver, AdminDashboardPageUI.BUTTON_GO_BY_SKU);
		clickToElement(driver, AdminDashboardPageUI.BUTTON_GO_BY_SKU);

	}

	public String getEditProductDetail(String label, String value) {
		waitForElementVisible(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, label);
		return getElementAttribute(driver, AdminDashboardPageUI.INPUT_SEARCH_BY_LABEL, value, label);

	}
}
