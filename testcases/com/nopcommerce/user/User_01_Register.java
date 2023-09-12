package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Epic("web")
@Feature("User")
public class User_01_Register extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, confirmPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		System.out.println("Run on " + browserName);
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName, GlobalConstants.PORTAL_PAGE_URL);

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

		emailAddress = "Automation" + generateFakeNumber() + "@gmai.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		confirmPassword = "123456";

	}

	@Test

	public void TC_01_Register_Empty_Data() {

		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();

		log.info("User_01_Register - Step 02: Click to Button Register");
		registerPage.clickToRegisterButton();
		log.info("User_01_Register - Step 03: Verify error message first name");
		verifyEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		log.info("User_01_Register - Step 03: Verify error message last name");
		verifyEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		log.info("User_01_Register - Step 03: Verify error message email");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		log.info("User_01_Register - Step 03: Verify error message password");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		log.info("User_01_Register - Step 03: Verify error message confirm password");
		verifyEquals(registerPage.getErrorMessageAtComfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();

		log.info("User_01_Register - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_01_Register - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_01_Register - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox("2141@");
		log.info("User_01_Register - Step 02: In put to password with value: " + password);
		registerPage.inputToPasswordTextBox(password);
		log.info("User_01_Register - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_01_Register - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();

		log.info("User_01_Register - Step 04: Verify error message invalid email");
		verifyEquals(registerPage.getErrorEmail(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();

		log.info("User_01_Register - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_01_Register - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_01_Register - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_01_Register - Step 02: In put to password with value: " + password);
		registerPage.inputToPasswordTextBox(password);
		log.info("User_01_Register - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_01_Register - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();

		log.info("User_01_Register - Step 04: Verify register success");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();
		log.info("User_01_Register - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_01_Register - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_01_Register - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_01_Register - Step 02: In put to password with value: " + password);
		registerPage.inputToPasswordTextBox(password);
		log.info("User_01_Register - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_01_Register - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();

		log.info("User_01_Register - Step 04: Verify error message existing email");
		verifyEquals(registerPage.getErrorExistingEmail(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();
		log.info("User_01_Register - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_01_Register - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_01_Register - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_01_Register - Step 02: In put to password with value: ");
		registerPage.inputToPasswordTextBox("123");
		log.info("User_01_Register - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_01_Register - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();
		log.info("User_01_Register - Step 04: Verify error message password at least 6 character");

		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Comfirm_Password() {
		log.info("User_01_Register - Step 01: Click to RegisterLink");
		homePage.clickToRegister();
		log.info("User_01_Register - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_01_Register - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_01_Register - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_01_Register - Step 02: In put to password with value: ");
		registerPage.inputToPasswordTextBox(password);
		log.info("User_01_Register - Step 02: In put to confirm password with value: " + "123567");
		registerPage.inputToConfirmPasswordTextBox("123567");
		log.info("User_01_Register - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();
		log.info("User_01_Register - Step 04: Verify error message confirm password");
		verifyEquals(registerPage.getErrorMessageAtComfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

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
