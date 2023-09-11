package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.DetailPageUI;
import PageUIs.nopcommerce.user.ShoppingCartPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void hoverShoppingCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.LINK_SHOPPING_CART);

		hoverMouseToElement(driver, ShoppingCartPageUI.LINK_SHOPPING_CART);

	}

	public String getSuccessAddToCart() {
		waitForElementVisible(driver, ShoppingCartPageUI.SUCCESS_ADD_TO_CART);
		return getTextElement(driver, ShoppingCartPageUI.SUCCESS_ADD_TO_CART);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, ShoppingCartPageUI.GET_SUB_TOTAL);
		return getTextElement(driver, ShoppingCartPageUI.GET_SUB_TOTAL);
	}

	public DetailPageObject clickToEditToCart() {

		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_ITEM);
		clickToElement(driver, ShoppingCartPageUI.EDIT_ITEM);
		return PageGeneratorManager.getDetailProductPage(driver);
	}

	public String getPriceProduct() {
		waitForElementVisible(driver, ShoppingCartPageUI.GET_PRICE_PRODUCT);
		return getTextElement(driver, ShoppingCartPageUI.GET_PRICE_PRODUCT);

	}

	public String getTotalProduct() {
		waitForElementVisible(driver, ShoppingCartPageUI.GET_TOTAL_PRODUCT);
		return getTextElement(driver, ShoppingCartPageUI.GET_TOTAL_PRODUCT);
	}

	public void removeFromCart() {
		waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_FROM_CART);
		clickToElement(driver, ShoppingCartPageUI.REMOVE_FROM_CART);

	}

	public String getShoppingCartEmpty() {
		waitForElementVisible(driver, ShoppingCartPageUI.SHOPPING_CART_EMPTY);
		return getTextElement(driver, ShoppingCartPageUI.SHOPPING_CART_EMPTY);
	}

	public void inputQuantityCart(String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.INPUT_QUANTITY_CART);
		getElement(driver, ShoppingCartPageUI.INPUT_QUANTITY_CART).clear();
		sendKeysToElement(driver, ShoppingCartPageUI.INPUT_QUANTITY_CART, value);

	}

	public void clickButtonToLabel(String label) {
		waitForElementClickable(driver, ShoppingCartPageUI.BUTTON_TO_LABEL, label);
		clickToElement(driver, ShoppingCartPageUI.BUTTON_TO_LABEL, label);

	}

	public void clickCheckboxAgreeProduct() {
		waitForElementClickable(driver, ShoppingCartPageUI.CHECKBOX_AGREE_CHECKOUT);
		clickToElement(driver, ShoppingCartPageUI.CHECKBOX_AGREE_CHECKOUT);

	}

	public void inputToBillingAddressByLabel(String label, String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.INPUT_TO_BILLING_ADDRESS_BY_LABEL, label);
		clearToInput(driver, ShoppingCartPageUI.INPUT_TO_BILLING_ADDRESS_BY_LABEL, label);
		sendKeysToElement(driver, ShoppingCartPageUI.INPUT_TO_BILLING_ADDRESS_BY_LABEL, value, label);

	}

	public void selectToBillingAddressByLabel(String label, String value) {
		waitForElementVisible(driver, ShoppingCartPageUI.SELECT_TO_BILLING_ADDRESS_BY_LABEL, label);
		selectItemInDefaultDropDown(driver, ShoppingCartPageUI.SELECT_TO_BILLING_ADDRESS_BY_LABEL, value, label);

	}

	public void clickToButtonCheckoutContinue(String label) {
		waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CHECKOUT_TO_LABEL, label);
		clickToElement(driver, ShoppingCartPageUI.BUTTON_CHECKOUT_TO_LABEL, label);

	}

	public void chooseShippingMethod(String label) {
		waitForElementClickable(driver, ShoppingCartPageUI.RADIO_TO_ORDER_BY_LABEL, label);
		checkToDefaultCheckBoxRadio(driver, ShoppingCartPageUI.RADIO_TO_ORDER_BY_LABEL, label);

	}

	public boolean isPaymentInforDisplay() {
		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_PAYMENT_INFORMATION);
		return isElementDisplayd(driver, ShoppingCartPageUI.TEXT_PAYMENT_INFORMATION);

	}

	public String getBillingAddressByLabel(String title, String label) {
		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_SUCCESS_BY_LABEL, title, label);
		return getTextElement(driver, ShoppingCartPageUI.TEXT_SUCCESS_BY_LABEL, title, label);

	}

	public String getCartTotalByLabel(String label) {
		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_CART_TOTAL_BY_LABEL, label);
		return getTextElement(driver, ShoppingCartPageUI.TEXT_CART_TOTAL_BY_LABEL, label);
	}

	public String getTitleOrderSuccess() {
		waitForElementVisible(driver, ShoppingCartPageUI.GET_TITLE_ORDER_SUCCESS);
		return getTextElement(driver, ShoppingCartPageUI.GET_TITLE_ORDER_SUCCESS);
	}

	public String getNumberOrderSuccess() {
		waitForElementVisible(driver, ShoppingCartPageUI.GET_NUMBER_ORDER_SUCCESS);
		return getTextElement(driver, ShoppingCartPageUI.GET_NUMBER_ORDER_SUCCESS);
	}

	public void clickToButtonConfirm() {
		waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_CONFIRM_ORDER);
		clickToElement(driver, ShoppingCartPageUI.BUTTON_CONFIRM_ORDER);
	}

	public MyAccountPageObject clickToHeaderLinkAccount() {
		waitForElementVisible(driver, ShoppingCartPageUI.CLICK_MY_ACCOUNT_LINK);
		clickToElement(driver, ShoppingCartPageUI.CLICK_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}

}
