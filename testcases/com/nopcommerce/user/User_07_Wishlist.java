package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nomCommerce.user.CompareProductsPageObject;
import pageObjects.nomCommerce.user.DetailPageObject;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.RecentlyViewProductPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;
import pageObjects.nomCommerce.user.WishlistPageObject;

public class User_07_Wishlist extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DetailPageObject detailPage;
	private WishlistPageObject wishlistPage;
	private CompareProductsPageObject compareProduct;
	private RecentlyViewProductPageObject recentlyViewProduct;

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
		homePage.clickToHeaderLogo();

	}

	@Test
	public void Wishlist_01_Add_Product_Wishlist() {
		log.info("User_07_Wishlist - Step 01: Click to add to cart with product title apple macbook");
		detailPage = homePage.clickAddToCart("Apple MacBook Pro 13-inch", "Add to cart");
		log.info("User_07_Wishlist - Step 01: Click to add to wishlist ");
		detailPage.clickToButtonWithLable("Add to wishlist");
		verifyTrue(detailPage.isAddToWishlistSucces());
		wishlistPage = detailPage.clickToLinkBarNotification();
		verifyEquals(wishlistPage.getProductToAddSuccess(), "Apple MacBook Pro 13-inch");
		log.info("User_07_Wishlist - Step 01: Click share info link ");
		wishlistPage.clickToShareInfo();

	}

	@Test
	public void Wishlist_02_Add_Product_To_Cart() {
		log.info("User_07_Wishlist - Step 01: Click to checkbox add to cart ");
		wishlistPage.clickToCheckboxAddToCart();
		log.info("User_07_Wishlist - Step 02: Click to button add to cart ");
		wishlistPage.clickToButtonAddToCart();
		log.info("User_07_Wishlist - Step 03: Verify add product success");
		verifyTrue(wishlistPage.addProductSuccess());

	}

	@Test
	public void Wishlist_03_Remove_Product_In_Wishlist() {
		wishlistPage.clickToRemove();
		verifyEquals(wishlistPage.getEmptyCart(), "Your Shopping Cart is empty!");

	}

	@Test
	public void Wishlist_04_Add_Product_To_Compare() {
		homePage = wishlistPage.clickToHeaderLogo();

		log.info("User_07_Wishlist - Step 01: Click to add to cart with product title apple macbook");
		homePage.clickAddToCart("Apple MacBook Pro 13-inch", "Add to compare list");
		homePage.clickAddToCart("Build your own computer", "Add to compare list");
		compareProduct = homePage.openToCompareProduct();
		verifyTrue(compareProduct.isCompareProductByLabel("Name"));
		verifyTrue(compareProduct.isCompareProductByLabel("Price"));
		verifyTrue(compareProduct.isCompareProductByLabel("Screensize"));
		compareProduct.clickToButtonClearList();
		verifyEquals(compareProduct.getNoDataCompare(), "You have no items to compare.");
	}

	@Test
	public void Wishlist_05_Recently_Viewed_Products() {
		homePage = wishlistPage.clickToHeaderLogo();
		homePage.clickAddToCart("Build your own computer", "Add to cart");

		homePage.clickToHeaderLogo();
		homePage.clickAddToCart("HTC One M8 Android L 5.0 Lollipop", "Add to cart");

		homePage.clickAddToCart("$25 Virtual Gift Card", "Add to cart");

		homePage.clickToHeaderLogo();
		recentlyViewProduct = homePage.openToRecentlyViewProducts();
		verifyEquals(recentlyViewProduct.getSizeItem(), 3);

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}

}
