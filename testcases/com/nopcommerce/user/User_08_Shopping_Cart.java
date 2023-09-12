package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUIs.nopcommerce.user.ShoppingCartPageUI;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nomCommerce.user.CompareProductsPageObject;
import pageObjects.nomCommerce.user.DetailPageObject;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.OrderProductPageObject;
import pageObjects.nomCommerce.user.RecentlyViewProductPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;
import pageObjects.nomCommerce.user.ShoppingCartPageObject;
import pageObjects.nomCommerce.user.WishlistPageObject;

public class User_08_Shopping_Cart extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, firstNameAddress, lastNameAddress, company, city,
			address1, address2, zip, phoneNumber, faxNumber;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DetailPageObject detailPage;

	private ShoppingCartPageObject shoppingCart;
	private MyAccountPageObject myAccount;
	private OrderProductPageObject orderProduct;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName, GlobalConstants.PORTAL_PAGE_URL);

		emailAddress = "Automation" + generateFakeNumber() + "@gmail.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		firstNameAddress = "Test";
		lastNameAddress = "FC";
		company = "FPT";
		address1 = "123 TON DUC THANG";
		address2 = "1223 TON DUC THANG";
		zip = "15151";
		city = "Ho Chi Minh";
		phoneNumber = "0195167461";
		faxNumber = "17156414";

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
	public void Cart_01_Add_Product_To_Cart() {
		detailPage = homePage.clickAddToCart("Build your own computer", "Add to cart");
		detailPage.selectToProductWithLable("RAM", "5");
		detailPage.checkBoxToProductWithLable("HDD", "400 GB [+$100.00]");
		detailPage.checkBoxToProductWithLable("OS", "Vista Premium [+$60.00]");
		detailPage.checkBoxToProductWithLable("Software", "Microsoft Office [+$50.00]");
		detailPage.checkBoxToProductWithLable("Software", "Acrobat Reader [+$10.00]");
		detailPage.checkBoxToProductWithLable("Software", "Total Commander [+$5.00]");
		detailPage.clickToButtonWithLable("Add to cart");
		shoppingCart = detailPage.openShoppingCart();

		shoppingCart.hoverShoppingCart();
		verifyEquals(shoppingCart.getSuccessAddToCart(), "There are 1 item(s) in your cart.");
		verifyEquals(shoppingCart.getSubTotal(), "$1,500.00");

	}

	@Test
	public void Cart_02_Edit_Product_To_Cart() {
		detailPage = shoppingCart.clickToEditToCart();
		detailPage.selectToProductWithLable("Processor", "1");
		detailPage.selectToProductWithLable("RAM", "4");
		detailPage.checkBoxToProductWithLable("HDD", "320 GB");
		detailPage.checkBoxToProductWithLable("OS", "Vista Home [+$50.00]");
		detailPage.checkBoxToProductWithLable("Software", "Microsoft Office [+$50.00]");
		detailPage.unCheckBoxToProductWithLable("Software", "Acrobat Reader [+$10.00]");
		detailPage.unCheckBoxToProductWithLable("Software", "Total Commander [+$5.00]");
		detailPage.inputQuantityItem("2");
		detailPage.clickToButtonWithLable("Update");
		shoppingCart = detailPage.openShoppingCart();
		verifyEquals(shoppingCart.getPriceProduct(), "$1,320.00");
		verifyEquals(shoppingCart.getTotalProduct(), "$2,640.00");

	}

	@Test
	public void Cart_03_Remove_Product_To_Cart() {
		shoppingCart.removeFromCart();
		verifyEquals(shoppingCart.getShoppingCartEmpty(), "Your Shopping Cart is empty!");
	}

	@Test
	public void Cart_04_Update_Product_To_Cart() {
		homePage.clickToHeaderLogo();
		homePage.clickAddToCart("HTC One M8 Android L 5.0 Lollipop", "Add to cart");
		detailPage.openShoppingCart();
		shoppingCart.inputQuantityCart("10");
		shoppingCart.clickButtonToLabel("Update shopping cart");
		verifyEquals(shoppingCart.getTotalProduct(), "$2,450.00");
		shoppingCart.removeFromCart();

	}

	@Test
	public void Cart_05_Checkout_Product_To_Cart() {
		homePage.clickToHeaderLogo();
		detailPage = homePage.clickAddToCart("Apple MacBook Pro 13-inch", "Add to cart");
		detailPage.clickToButtonWithLable("Add to cart");
		shoppingCart = detailPage.openShoppingCart();
		shoppingCart.clickCheckboxAgreeProduct();
		shoppingCart.clickButtonToLabel(" Checkout ");
		shoppingCart.inputToBillingAddressByLabel("First name:", firstNameAddress);
		shoppingCart.inputToBillingAddressByLabel("Last name:", lastNameAddress);
		shoppingCart.inputToBillingAddressByLabel("Email:", emailAddress);
		shoppingCart.inputToBillingAddressByLabel("Company:", company);
		shoppingCart.selectToBillingAddressByLabel("Country:", "82");
		shoppingCart.inputToBillingAddressByLabel("City:", city);
		shoppingCart.inputToBillingAddressByLabel("Address 1:", address1);
		shoppingCart.inputToBillingAddressByLabel("Address 2:", address2);
		shoppingCart.inputToBillingAddressByLabel("Zip / postal code:", zip);
		shoppingCart.inputToBillingAddressByLabel("Phone number:", phoneNumber);
		shoppingCart.inputToBillingAddressByLabel("Fax number:", faxNumber);
		shoppingCart.clickToButtonCheckoutContinue("Billing address");
		shoppingCart.chooseShippingMethod("Next Day Air ($0.00)");
		shoppingCart.clickToButtonCheckoutContinue("Shipping method");
		shoppingCart.clickToButtonCheckoutContinue("Payment method");
		verifyTrue(shoppingCart.isPaymentInforDisplay());
		shoppingCart.clickToButtonCheckoutContinue("Payment information");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "name").trim(),
				firstNameAddress + lastNameAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "email").trim(),
				"Email: " + emailAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "phone").trim(), "Phone: " + phoneNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "fax").trim(), "Fax: " + faxNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "company").trim(), company);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "address1").trim(), address1);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "address2").trim(), address2);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "city-state-zip").trim(),
				city + "," + zip);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "country").trim(), "Viet Nam");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Payment", "payment-method").trim(),
				"Payment Method: Check / Money Order");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "name").trim(),
				firstNameAddress + lastNameAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "email").trim(),
				"Email: " + emailAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "phone").trim(),
				"Phone: " + phoneNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "company").trim(), company);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "address1").trim(), address1);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "address2").trim(), address2);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "city-state-zip").trim(),
				city + "," + zip);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "country").trim(), "Viet Nam");
		verifyEquals(shoppingCart.getCartTotalByLabel("Sub-Total:"), "$3,600.00");
		verifyEquals(shoppingCart.getCartTotalByLabel("Total:"), "$3,600.00");
		verifyEquals(shoppingCart.getCartTotalByLabel("You will earn:"), "360 points");
		shoppingCart.clickToButtonConfirm();
		verifyEquals(shoppingCart.getTitleOrderSuccess(), "Your order has been successfully processed!");
		verifyEquals(shoppingCart.getNumberOrderSuccess(), "Order number: 1031");
		myAccount = shoppingCart.clickToHeaderLinkAccount();
		myAccount.clickToLinkAccountListbox("Orders");
		orderProduct = PageGeneratorManager.getOrderProduct(driver);
		verifyEquals(shoppingCart.getTitleOrderSuccess(), "Order Number: 1031");
		orderProduct.clickToDetailsOrder();
		verifyEquals(shoppingCart.getNumberOrderSuccess(), "Order #1031");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "name").trim(),
				firstNameAddress + lastNameAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "email").trim(),
				"Email: " + emailAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "phone").trim(), "Phone: " + phoneNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "fax").trim(), "Fax: " + faxNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "company").trim(), company);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "address1").trim(), address1);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "address2").trim(), address2);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "city-state-zip").trim(),
				city + "," + zip);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Billing Address", "country").trim(), "Viet Nam");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Payment", "payment-method").trim(),
				"Payment Method: Check / Money Order");
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "name").trim(),
				firstNameAddress + lastNameAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "email").trim(),
				"Email: " + emailAddress);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "phone").trim(),
				"Phone: " + phoneNumber);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "company").trim(), company);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "address1").trim(), address1);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "address2").trim(), address2);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "city-state-zip").trim(),
				city + "," + zip);
		verifyEquals(shoppingCart.getBillingAddressByLabel("Shipping Address", "country").trim(), "Viet Nam");
		verifyEquals(shoppingCart.getCartTotalByLabel("Sub-Total:"), "$3,600.00");
		verifyEquals(shoppingCart.getCartTotalByLabel("Order Total:"), "$3,600.00");

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}
}
