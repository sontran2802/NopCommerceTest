package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.DetailPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class DetailPageObject extends BasePage {
	WebDriver driver;

	public DetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonWithLable(String nameButton) {
		waitForElementClickable(driver, DetailPageUI.OVERVIEW_BUTTON, nameButton);
		clickToElement(driver, DetailPageUI.OVERVIEW_BUTTON, nameButton);
	}

	public WishlistPageObject clickToLinkBarNotification() {
		waitForElementClickable(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
		clickToElement(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}

	public ShoppingCartPageObject openShoppingCart() {
		waitForElementClickable(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
		clickToElement(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
		return PageGeneratorManager.getShoppingCart(driver);
	}

	public boolean isAddToWishlistSucces() {
		waitForElementClickable(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
		return isElementDisplayd(driver, DetailPageUI.BAR_NOTIFICATION_LINK);
	}

	public void selectToProductWithLable(String label, String value) {
		waitForElementVisible(driver, DetailPageUI.SELECT_PRODUCT_BY_LABEL, label);
		selectItemInDefaultDropDown(driver, DetailPageUI.SELECT_PRODUCT_BY_LABEL, value, label);

	}

	public void checkBoxToProductWithLable(String label, String value) {
		waitForElementVisible(driver, DetailPageUI.RADIO_CHECKBOX_PRODUCT_BY_LABEL, label, value);
		checkToDefaultCheckBoxRadio(driver, DetailPageUI.RADIO_CHECKBOX_PRODUCT_BY_LABEL, label, value);
	}

	public void unCheckBoxToProductWithLable(String label, String value) {
		waitForElementVisible(driver, DetailPageUI.RADIO_CHECKBOX_PRODUCT_BY_LABEL, label, value);
		unCheckToDefaultCheckBoxRadio(driver, DetailPageUI.RADIO_CHECKBOX_PRODUCT_BY_LABEL, label, value);
	}

	public void hoverShoppingCart() {
		waitForElementVisible(driver, DetailPageUI.LINK_SHOPPING_CART);

		hoverMouseToElement(driver, DetailPageUI.LINK_SHOPPING_CART);

	}

	public void inputQuantityItem(String value) {
		waitForElementVisible(driver, DetailPageUI.INPUT_QUANTITY_ITEM);
		getElement(driver, DetailPageUI.INPUT_QUANTITY_ITEM).clear();
		sendKeysToElement(driver, DetailPageUI.INPUT_QUANTITY_ITEM, value);

	}

}
