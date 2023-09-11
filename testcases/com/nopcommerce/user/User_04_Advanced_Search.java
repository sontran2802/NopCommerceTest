package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nomCommerce.user.AdvancedSearchPageObject;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;

public class User_04_Advanced_Search extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, dataNotFound, dataRelative, dataAbsolute,
			searchMacbookPro;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccount;
	private AdvancedSearchPageObject searchProduct;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		emailAddress = "Automation" + generateFakeNumber() + "@gmail.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		dataNotFound = "Macbook Pro 2050";
		dataRelative = "Lenovo";
		dataAbsolute = "Lenovo Thinkpad X1 Carbon Laptop";
		searchMacbookPro = "Apple MacBook Pro";
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
		searchProduct = homePage.openAdvanceSearchPage();

	}

	@Test
	public void Search_01_Empty_Data() {
		log.info("User_04_Search - Step 01: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 02:Verify error message less 3 characters");
		verifyEquals(searchProduct.getErrorMessageMinimumLength(), "Search term minimum length is 3 characters");

	}

	@Test
	public void Search_02_Data_Not_Exist() {
		log.info("User_04_Search - Step 01: Input to search with data not exist: " + dataNotFound);
		searchProduct.inputToSearch(dataNotFound);
		log.info("User_04_Search - Step 02: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 03: Verify products not found");
		verifyEquals(searchProduct.getNotFoundProducts(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_03_Product_Name_Relative() {
		log.info("User_04_Search - Step 01: Input to search with data relative: " + dataRelative);
		searchProduct.inputToSearch(dataRelative);
		log.info("User_04_Search - Step 02: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 03: Verify products Lenovo IdeaCentre 600 All-in-One PC isdisplay");
		verifyTrue(searchProduct.isdisplayProductsWithText("Lenovo IdeaCentre 600 All-in-One PC"));
		log.info("User_04_Search - Step 03: Verify products Lenovo Thinkpad X1 Carbon Laptop");
		verifyTrue(searchProduct.isdisplayProductsWithText("Lenovo Thinkpad X1 Carbon Laptop"));

	}

	@Test
	public void Search_04_Product_Name_Absolute() {
		log.info("User_04_Search - Step 01: Input to search with data relative: " + dataAbsolute);
		searchProduct.inputToSearch(dataAbsolute);
		log.info("User_04_Search - Step 02: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 03: Verify products Lenovo Thinkpad X1 Carbon Laptop");
		verifyTrue(searchProduct.isdisplayProductsWithText("Lenovo Thinkpad X1 Carbon Laptop"));

	}

	@Test
	public void Search_05_Parent_Categories() {
		log.info("User_04_Search - Step 01: Input to search with data: " + searchMacbookPro);
		searchProduct.inputToSearch(searchMacbookPro);
		log.info("User_04_Search - Step 02: Click to checkbox advanced search");
		searchProduct.clickToCheckboxBylabel("Advanced search");
		log.info("User_04_Search - Step 03: Select with label category");
		searchProduct.selectBylabel("Category:", "1");

		log.info("User_04_Search - Step 04: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 05: Verify products not found");
		verifyEquals(searchProduct.getNotFoundProducts(), "No products were found that matched your criteria.");

	}

	@Test
	public void Search_06_Sub_Categories() {
		log.info("User_04_Search - Step 01: Input to search with data: " + searchMacbookPro);
		searchProduct.inputToSearch(searchMacbookPro);
		log.info("User_04_Search - Step 02: Click to checkbox advanced search");
		searchProduct.clickToCheckboxBylabel("Advanced search");
		log.info("User_04_Search - Step 03: Select with label category");
		searchProduct.selectBylabel("Category:", "1");
		log.info("User_04_Search - Step 04: Click to checkbox automatically search");
		searchProduct.clickToCheckboxBylabel("Automatically search sub categories");
		log.info("User_04_Search - Step 05: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 06: Verify products Apple Macbook Pro 13-inch isdisplay");
		verifyTrue(searchProduct.isdisplayProductsWithText("Apple MacBook Pro 13-inch"));

	}

	@Test
	public void Search_07_Incorrect_Manufaturer() {
		log.info("User_04_Search - Step 01: Input to search with data: " + searchMacbookPro);
		searchProduct.inputToSearch(searchMacbookPro);
		log.info("User_04_Search - Step 02: Click to checkbox advanced search");
		searchProduct.clickToCheckboxBylabel("Advanced search");
		log.info("User_04_Search - Step 03: Select with label category");
		searchProduct.selectBylabel("Category:", "1");
		log.info("User_04_Search - Step 04: Click to checkbox automatically search");
		searchProduct.clickToCheckboxBylabel("Automatically search sub categories");
		log.info("User_04_Search - Step 05: Select with label manufacturer");
		searchProduct.selectBylabel("Manufacturer:", "2");
		log.info("User_04_Search - Step 06: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 07: Verify products not found");
		verifyEquals(searchProduct.getNotFoundProducts(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_08_correct_Manufaturer() {
		log.info("User_04_Search - Step 01: Input to search with data: " + searchMacbookPro);
		searchProduct.inputToSearch(searchMacbookPro);
		log.info("User_04_Search - Step 02: Click to checkbox advanced search");
		searchProduct.clickToCheckboxBylabel("Advanced search");
		log.info("User_04_Search - Step 03: Select with label category");
		searchProduct.selectBylabel("Category:", "1");
		log.info("User_04_Search - Step 04: Click to checkbox automatically search");
		searchProduct.clickToCheckboxBylabel("Automatically search sub categories");
		log.info("User_04_Search - Step 05: Select with label manufacturer");
		searchProduct.selectBylabel("Manufacturer:", "1");
		log.info("User_04_Search - Step 06: Click to button search");
		searchProduct.clickToButtonSearch();
		log.info("User_04_Search - Step 07: Verify products Apple Macbook Pro 13-inch isdisplay");
		verifyTrue(searchProduct.isdisplayProductsWithText("Apple MacBook Pro 13-inch"));

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}

}
