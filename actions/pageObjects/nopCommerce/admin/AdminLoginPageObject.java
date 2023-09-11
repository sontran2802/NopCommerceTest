package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminDashboardPageUI;
import PageUIs.nopcommerce.admin.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextBox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
	}

	public AdminDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdmindDashboardPage(driver);
	}

	public AdminDashBoardPageObject loginAsAdmin(String emailAddress, String password) {
		inputToUserNameTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
	}

}
