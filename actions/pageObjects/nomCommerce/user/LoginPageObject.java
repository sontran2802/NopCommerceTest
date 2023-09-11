package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.LoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToButtonLogin() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	@Step("Get Error Message Email Textbox")
	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MASSAGE);
		return getTextElement(driver, LoginPageUI.EMAIL_ERROR_MASSAGE);
	}

	@Step("Enter to password textbox with value {0}")
	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORDL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORDL_TEXTBOX, password);

	}

	public void inputToEmailTextBox(String Email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, Email);

	}

	public String getErrorMessageInValidEmail() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MASSAGE);
		return getTextElement(driver, LoginPageUI.INVALID_EMAIL_ERROR_MASSAGE);
	}

	public String getErrorMessageNotFoundEmail() {
		waitForElementVisible(driver, LoginPageUI.NOT_FOUND_EMAIL_PASSWORD_ERROR_MASSAGE);
		return getTextElement(driver, LoginPageUI.NOT_FOUND_EMAIL_PASSWORD_ERROR_MASSAGE);
	}

	public String getErrorMessageExistingPassword() {
		waitForElementVisible(driver, LoginPageUI.NOT_FOUND_EMAIL_PASSWORD_ERROR_MASSAGE);
		return getTextElement(driver, LoginPageUI.NOT_FOUND_EMAIL_PASSWORD_ERROR_MASSAGE);
	}

	public HomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextBox(emailAddress);

		inputToPasswordTextBox(password);
		return clickToButtonLogin();

	}

}
