package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.WishlistPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductToAddSuccess() {
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
		return getTextElement(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}

	public void clickToShareInfo() {
		waitForElementVisible(driver, WishlistPageUI.SHARE_INFO_LINK);
		clickToElement(driver, WishlistPageUI.SHARE_INFO_LINK);

	}

	public void clickToCheckboxAddToCart() {
		waitForElementClickable(driver, WishlistPageUI.CHECKBOX_ADD_TO_CART);
		checkToDefaultCheckBoxRadio(driver, WishlistPageUI.CHECKBOX_ADD_TO_CART);

	}

	public void clickToButtonAddToCart() {
		waitForElementClickable(driver, WishlistPageUI.BUTTON_ADD_TO_CART);
		clickToElement(driver, WishlistPageUI.BUTTON_ADD_TO_CART);

	}

	public boolean addProductSuccess() {
		waitForElementVisible(driver, WishlistPageUI.ADD_SHOPPING_CART_SUCCESS);
		return isElementDisplayd(driver, WishlistPageUI.ADD_SHOPPING_CART_SUCCESS);
	}

	public void clickToRemove() {
		waitForElementClickable(driver, WishlistPageUI.BUTTON_REMOVE_CART);
		clickToElement(driver, WishlistPageUI.BUTTON_REMOVE_CART);

	}

	public String getEmptyCart() {
		waitForElementVisible(driver, WishlistPageUI.CART_IS_EMPTY);
		return getTextElement(driver, WishlistPageUI.CART_IS_EMPTY).trim();
	}

	public HomePageObject clickToHeaderLogo() {
		waitForElementClickable(driver, WishlistPageUI.HEADER_LOGO);
		clickToElement(driver, WishlistPageUI.HEADER_LOGO);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
