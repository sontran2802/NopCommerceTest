package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;

public class User_02_Login extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, invalidEmail, notFoundEmail, invalidPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
//		driver = new FirefoxDriver();
		driver = getBrowserDriver(browserName);
		loginPage = new LoginPageObject(driver);

		emailAddress = "Automation" + generateFakeNumber() + "@gmail.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "141@141@411";
		notFoundEmail = "d21awa@gmail.com";
		invalidPassword = "123754";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		log.info("User_02_Login - Step 01: Click to RegisterLink");
		registerPage = homePage.clickToRegister();

		log.info("User_02_Login - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_02_Login - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_02_Login - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_02_Login - Step 02: In put to password with value: " + password);
		registerPage.inputToPasswordTextBox(password);
		log.info("User_02_Login - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_02_Login - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();
		homePage.clickToLoginLink();
	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("User_02_Login - Step 01: Click to login link");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 02: Verify error message email");
		verifyEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");

	}

	public void Login_02_Invalid_Email() {
		log.info("User_02_Login - Step 01: Click to login link");
		homePage.clickToLoginLink();

		log.info("User_02_Login - Step 02: In put to email with value: " + invalidEmail);
		loginPage.inputToEmailTextBox(invalidEmail);
		log.info("User_02_Login - Step 02: In put to password with value: " + password);
		loginPage.inputToPasswordTextBox(password);
		log.info("User_02_Login - Step 03: Click to Button Login");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 04: Verify error message invalid email");
		verifyEquals(loginPage.getErrorMessageInValidEmail(), "Wrong email");

	}

	public void Login_03_Email_Not_Found() {
		log.info("User_02_Login - Step 01: Click to login link");
		homePage.clickToLoginLink();

		log.info("User_02_Login - Step 02: In put to email with value: " + notFoundEmail);
		loginPage.inputToEmailTextBox(notFoundEmail);

		log.info("User_02_Login - Step 02: In put to password with value: " + password);
		loginPage.inputToPasswordTextBox(password);
		log.info("User_02_Login - Step 03: Click to Button Login");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 04: Verify error message not found email");
		verifyEquals(loginPage.getErrorMessageNotFoundEmail(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	public void Login_04_Existing_Email_Empty_Password() {
		log.info("User_02_Login - Step 01: Click to login link");
		homePage.clickToLoginLink();
		log.info("User_02_Login - Step 02: In put to email with value: " + emailAddress);
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_02_Login - Step 03: Click to Button Login");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 04: Verify error message existing password");
		verifyEquals(loginPage.getErrorMessageExistingPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	public void Login_05_Existing_Email_Incorrect_Password() {
		log.info("User_02_Login - Step 01: Click to login link");
		homePage.clickToLoginLink();
		log.info("User_02_Login - Step 02: In put to email with value: " + emailAddress);
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_02_Login - Step 02: In put invalid password with value: " + invalidPassword);
		loginPage.inputToPasswordTextBox(invalidPassword);

		log.info("User_02_Login - Step 03: Click to Button Login");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 04: Verify error message incorrect password");
		verifyEquals(loginPage.getErrorMessageExistingPassword(),
				"Login was unsuccessful. Please correct the errors and try again."
						+ "\nThe credentials provided are incorrect");

	}

	public void Login_06_Valid_Email_Password() {
		log.info("User_02_Login - Step 01: Click to login link");

		homePage.clickToLoginLink();
		log.info("User_02_Login - Step 02: In put to email with value: " + emailAddress);
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_02_Login - Step 02: In put to password with value: " + password);
		loginPage.inputToPasswordTextBox(password);
		log.info("User_02_Login - Step 03: Click to Button Login");
		loginPage.clickToButtonLogin();
		log.info("User_02_Login - Step 04: Verify login success");
		verifyTrue(homePage.loginSuccess());

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}

}
