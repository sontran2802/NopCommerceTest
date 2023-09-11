package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.data.UserData.MyAccount;

import PageUIs.nopcommerce.user.HomePageUI;
import PageUIs.nopcommerce.user.MyAccountPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPageObject clickToLinkMyAccount() {
		waitForElementVisible(driver, MyAccountPageUI.MYACCOUNT_LINK);
		clickToElement(driver, MyAccountPageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);

	}

	public void clickToRadioButtonByLabel(String radioButtonLabel) {
		waitForElementVisible(driver, MyAccountPageUI.RADIO_BUTTON_BY_LABEL, radioButtonLabel);

		checkToDefaultCheckBoxRadio(driver, MyAccountPageUI.RADIO_BUTTON_BY_LABEL, radioButtonLabel);

	}

	public void selectToDateOfBirth(String selectName, String value) {
		waitForElementVisible(driver, MyAccountPageUI.SELECT_TO_DATE_OF_BIRTH, selectName);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.SELECT_TO_DATE_OF_BIRTH, value, selectName);

	}

	public void clickToButtonSave() {
		waitForElementVisible(driver, MyAccountPageUI.BUTTON_SAVE);
		clickToElement(driver, MyAccountPageUI.BUTTON_SAVE);

	}

	public String getValueSuccess(String label, String value) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_BY_LABEL, label);
		return getElementAttribute(driver, MyAccountPageUI.TEXTBOX_BY_LABEL, value, label);

	}

	public void inputToLable(String lable, String value) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_BY_LABEL, lable);
		sendKeysToElement(driver, MyAccountPageUI.TEXTBOX_BY_LABEL, value, lable);

	}

	public boolean checkGenderSelected(String radioButtonLabel) {
		waitForElementVisible(driver, MyAccountPageUI.RADIO_BUTTON_BY_LABEL, radioButtonLabel);
		return isElementSelected(driver, MyAccountPageUI.RADIO_BUTTON_BY_LABEL, radioButtonLabel);

	}

	public boolean checkDateOfBirthSelected(String selectName, String value) {
		waitForElementVisible(driver, MyAccountPageUI.CHECK_SELECT_TO_DATE_OF_BIRTH, selectName, value);
		return isElementSelected(driver, MyAccountPageUI.CHECK_SELECT_TO_DATE_OF_BIRTH, selectName, value);
	}

	public void clickToLinkAccountListbox(String linkName) {
		waitForElementVisible(driver, MyAccountPageUI.LINK_ACCOUNT_LISTBOX, linkName);
		clickToElement(driver, MyAccountPageUI.LINK_ACCOUNT_LISTBOX, linkName);

	}

	public void clickToButtonAddNew() {
		waitForElementVisible(driver, MyAccountPageUI.BUTTON_ADD_NEW);
		clickToElement(driver, MyAccountPageUI.BUTTON_ADD_NEW);

	}

	public void inputToLabelEditAddresses(String label, String value) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_EDIT_ADDRESS_BY_LABEL, label);
		sendKeysToElement(driver, MyAccountPageUI.TEXTBOX_EDIT_ADDRESS_BY_LABEL, value, label);

	}

	public void selectToCountry(String textValue) {
		waitForElementVisible(driver, MyAccountPageUI.SELECT_TO_ADDRESS_COUNTRY);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.SELECT_TO_ADDRESS_COUNTRY, textValue);

	}

	public void clickToSaveAddressButton() {
		waitForElementVisible(driver, MyAccountPageUI.BUTTON_SAVE_ADDRESS);
		clickToElement(driver, MyAccountPageUI.BUTTON_SAVE_ADDRESS);

	}

	public String getValueAddress(String lable) {
		waitForElementVisible(driver, MyAccountPageUI.GET_VALUE_ADDRESS_SUCCESS, lable);
		String value = getTextElement(driver, MyAccountPageUI.GET_VALUE_ADDRESS_SUCCESS, lable);
		return value.trim();
	}

	public void inputToChangePasswordWithLabel(String label, String password) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_CHANGE_PASSWORD_BY_LABEL, label);
		sendKeysToElement(driver, MyAccountPageUI.TEXTBOX_CHANGE_PASSWORD_BY_LABEL, password, label);

	}

	public void clickToButtonChangePassword() {
		waitForElementVisible(driver, MyAccountPageUI.BUTTON_CHANGE_PASSWORD);
		clickToElement(driver, MyAccountPageUI.BUTTON_CHANGE_PASSWORD);

	}

	public boolean isNotificationSuccess() {
		waitForElementVisible(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
		return isElementEnabled(driver, MyAccountPageUI.BAR_NOTIFICATION_SUCCESS);
	}

	public void closeBarNotification() {
		waitForElementVisible(driver, MyAccountPageUI.CLOSE_BAR_NOTIFICATION_SUCCESS);
		clickToElement(driver, MyAccountPageUI.CLOSE_BAR_NOTIFICATION_SUCCESS);
		sleepInSecond(1);

	}

	public HomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, MyAccountPageUI.LINK_LOGOUT);
		clickToElement(driver, MyAccountPageUI.LINK_LOGOUT);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
