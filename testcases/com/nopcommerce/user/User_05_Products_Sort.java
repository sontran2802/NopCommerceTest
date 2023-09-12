package com.nopcommerce.user;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nomCommerce.user.AdvancedSearchPageObject;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;
import pageObjects.nomCommerce.user.SortProductPageObject;

public class User_05_Products_Sort extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	private SortProductPageObject sortProducts;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.PORTAL_PAGE_URL);

		emailAddress = "Automation" + generateFakeNumber() + "@gmail.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";

		homePage = new HomePageObject(driver);

		log.info("User_03_My_account - Step 01: Click to RegisterLink");
		registerPage = homePage.clickToRegister();

		log.info("UUser_03_My_account - Step 02: In put to first name with value: " + firstName);
		registerPage.inputToFirstnameTextBox(firstName);
		log.info("User_03_My_account - Step 02: In put to last name with value: " + lastName);
		registerPage.inputToLastnameTextBox(lastName);
		log.info("User_03_My_account - Step 02: In put to email with value: " + emailAddress);
		registerPage.inputToEmailTextBox(emailAddress);
		log.info("User_03_My_account - Step 02: In put to password with value: " + password);
		registerPage.inputToPasswordTextBox(password);
		log.info("User_03_My_account - Step 02: In put to confirm password with value: " + password);
		registerPage.inputToConfirmPasswordTextBox(password);
		log.info("User_03_My_account - Step 03: Click to Button Register");
		registerPage.clickToRegisterButton();
		log.info("User_03_My_account - Step 04: Click to login link");
		loginPage = homePage.clickToLoginLink();
		log.info("User_03_My_account - Step 05: In put to email with value: " + emailAddress);
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_03_My_account - Step 06: In put to password with value: " + password);
		loginPage.inputToPasswordTextBox(password);
		log.info("User_03_My_account - Step 07: Click to Button Login");
		homePage = loginPage.clickToButtonLogin();
		log.info("User_03_My_account - Step 08: Verify login success");
		verifyTrue(homePage.loginSuccess());
		log.info("User_03_My_account - Step 08: Open sort products");
		sortProducts = homePage.openSortProductsPage();

	}

	@Test
	public void Sort_Products_01_Sort_With_Name_A_To_Z() {
		log.info("User_05_Products_Sort - Step 01: open note books");
		sortProducts.getNoteBooks();

		log.info("User_05_Products_Sort - Step 02: Select to type sort ");
		sortProducts.chooseTypeSort("Sort by", "5");
		log.info("User_05_Products_Sort - Step 03: Verify sort from A to Z");

		verifyTrue(sortProducts.checkSortWithLabel("Name: A to Z", "Name"));
	}

	@Test
	public void Sort_Products_02_Sort_With_Name_Z_To_A() {
		log.info("User_05_Products_Sort - Step 01: Select to type sort ");
		sortProducts.chooseTypeSort("Sort by", "6");
		log.info("User_05_Products_Sort - Step 02: Verify sort from Z to A");
		verifyTrue(sortProducts.checkSortWithLabel("Name: Z to A", "Name"));

	}

	@Test
	public void Sort_Products_03_Sort_With_Price_Low_To_High() {
		log.info("User_05_Products_Sort - Step 01: Select to type sort ");
		sortProducts.chooseTypeSort("Sort by", "10");
		log.info("User_05_Products_Sort - Step 02: Verify sort from Low to High");
		verifyTrue(sortProducts.checkSortWithLabel("Price: Low to High", "Prices"));

	}

	@Test
	public void Sort_Products_04_Sort_With_Price_High_To_Low() {
		log.info("User_05_Products_Sort - Step 01: Select to type sort ");
		sortProducts.chooseTypeSort("Sort by", "11");
		log.info("User_05_Products_Sort - Step 02: Verify sort from High to Low");
		verifyTrue(sortProducts.checkSortWithLabel("Price: High to Low", "Prices"));

	}

	@Test
	public void Sort_Products_05_Display_3_Products() {
		log.info("User_05_Products_Sort - Step 01: Select to type display 3 products ");
		sortProducts.chooseTypeSort("Display", "3");
		log.info("User_05_Products_Sort - Step 02: Verify display 3 products ");
		verifyEquals(sortProducts.sizeProducts(), 3);
		log.info("User_05_Products_Sort - Step 02: Verify next page icon isdisplay");
		verifyTrue(sortProducts.isNextPage());
		log.info("User_05_Products_Sort - Step 03: Click to icon next page");
		sortProducts.clickToNextPage();
		log.info("User_05_Products_Sort - Step 02: Verify previous page icon isdisplay");
		verifyTrue(sortProducts.isPreviousPage());
	}

	@Test
	public void Sort_Products_06_Display_6_Products() {
		log.info("User_05_Products_Sort - Step 01: Select to type display 6 products ");
		sortProducts.chooseTypeSort("Display", "6");

		log.info("User_05_Products_Sort - Step 02: Verify next page icon undisplay");
		verifyTrue(sortProducts.unDisplayNextPage());

	}

	@Test
	public void Sort_Products_07_Display_9_Products() {
		log.info("User_05_Products_Sort - Step 01: Select to type display 9 products ");
		sortProducts.chooseTypeSort("Display", "9");
		log.info("User_05_Products_Sort - Step 02: Verify next page icon undisplay");

		verifyTrue(sortProducts.unDisplayNextPage());

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}

}
