package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;

//@Listeners(commons.MethodListener.class)
@Listeners(reportConfig.AllureTestListener.class)
@Epic("Web")
@Feature("User")
public class Level_06_PageGenerator_Manager extends BaseTest {
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

		emailAddress = "Automation" + generateFakeNumber() + "@gmai.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "141@141@411";
		notFoundEmail = "d21awa@gmail.com";
		invalidPassword = "123754";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		registerPage = homePage.clickToRegister();

		registerPage.inputToFirstnameTextBox(firstName);
		registerPage.inputToLastnameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		loginPage = homePage.clickToLoginLink();
	}

	@Description("Log in Empty")
	@Step("Log in")
	@Test
	public void Login_01_Empty_Data() {
		loginPage.clickToButtonLogin();
		log.info("case 2");
		verifyEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");

	}

	@Description("Log in Invalid Email")
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextBox(invalidEmail);

		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToButtonLogin();

		System.out.println(loginPage.getErrorMessageInValidEmail());
		verifyEquals(loginPage.getErrorMessageInValidEmail(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(notFoundEmail);

		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToButtonLogin();
		verifyEquals(loginPage.getErrorMessageNotFoundEmail(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);

		loginPage.clickToButtonLogin();
		verifyEquals(loginPage.getErrorMessageExistingPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(invalidPassword);

		loginPage.clickToButtonLogin();

		verifyEquals(loginPage.getErrorMessageExistingPassword(),
				"Login was unsuccessful. Please correct the errors and try again."
						+ "\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);

		homePage = loginPage.clickToButtonLogin();
		verifyTrue(homePage.loginSuccess());

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
