package pageObjects.Jquery;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.Jquery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);

	}

	public void openAllPagingByPageNumber() {
		waitForElementClickable(driver, HomePageUI.LIST_PAGE_NUMBER);

		int allPageNumber = getElementSize(driver, HomePageUI.LIST_PAGE_NUMBER);
		for (int i = 1; i <= allPageNumber; i++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(i));
			sleepInSecond(1);

		}

	}

	public void enterToHeaderTextboxByLable(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE, headerLabel);
		sendKeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE, value, headerLabel);
		pressSendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABLE, Keys.ENTER, headerLabel);

	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayd(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}
}