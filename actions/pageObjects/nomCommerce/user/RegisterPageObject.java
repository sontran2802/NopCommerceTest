package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstnameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORDL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORDL_TEXTBOX, password);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorEmail() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MASSAGE);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
	}

	public String getErrorExistingEmail() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_MASSAGE);
		return getTextElement(driver, RegisterPageUI.EXISTING_EMAIL_MASSAGE);
	}

	public String getErrorConfirmPassword() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MASSAGE);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MASSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MASSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MASSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MASSAGE);
	}

	public String getErrorMessageAtComfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MASSAGE);
		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MASSAGE);
	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputToLastnameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORDL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORDL_TEXTBOX, confirmPassword);

	}

}
