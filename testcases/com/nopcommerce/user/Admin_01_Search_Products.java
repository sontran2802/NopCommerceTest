package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashBoardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class Admin_01_Search_Products extends BaseTest {

	private WebDriver driver;
	private AdminDashBoardPageObject adminDashBoard;
	private AdminLoginPageObject adminLoginPage;
	private AdminCustomersPageObject adminCustomersPage;
	String productName, email, password, firstName, lastName, gender, dateOfBirth, companyName, newsletter,
			customerRole, adminComment;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		System.out.println("Run on " + browserName);
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashBoard = adminLoginPage.clickToLoginButton();
		sleepInSecond(1);
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		email = "automationfc@gmail.com";
		password = "123456";
		firstName = "Automation";
		lastName = "FC";
		gender = "Male";
		dateOfBirth = "28/2/2000";
		companyName = "Automation FC";
		newsletter = "";
		customerRole = "Gu";
		adminComment = "";

	}

	public void Admin_01_Search_With_Product_Name() {
		log.info("Admin_01_Search_With_Product_Name: Click to Catalog");
		adminDashBoard.clickToSidebarBylabel("Catalog");
		log.info("Admin_01_Search_With_Product_Name: Click to Products");
		adminDashBoard.clickToSidebarBylabel(" Products");
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();
		log.info("Admin_01_Search_With_Product_Name: Get size products");
		verifyEquals(adminDashBoard.getSizeProducts(), 1);
		log.info("Admin_01_Search_With_Product_Name: Get text product name ");
		verifyEquals(adminDashBoard.getInfoProduct("3"), "Lenovo IdeaCentre 600 All-in-One PC");
		log.info("Admin_01_Search_With_Product_Name: Get text price product ");
		verifyEquals(adminDashBoard.getInfoProduct("5"), "500");

	}

	public void Admin_02_Search_With_Product_Name_Catefory() {
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Select category with computers");
		adminDashBoard.selectSearchByLabel("Category", "1");
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();
		log.info("Admin_01_Search_With_Product_Name: Verify search no data");
		verifyEquals(adminDashBoard.getEmptyDataTable(), "No data available in table");

	}

	public void Admin_03_Search_With_Product_Name_Catefory_Checked() {
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Select category with computers");
		adminDashBoard.selectSearchByLabel("Category", "1");
		adminDashBoard.selectToCheckboxByLabel("Search subcategories");
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();
		verifyEquals(adminDashBoard.getSizeProducts(), 1);
		log.info("Admin_01_Search_With_Product_Name: Get text product name ");
		verifyEquals(adminDashBoard.getInfoProduct("3"), "Lenovo IdeaCentre 600 All-in-One PC");
		log.info("Admin_01_Search_With_Product_Name: Get text price product ");
		verifyEquals(adminDashBoard.getInfoProduct("5"), "500");
	}

	public void Admin_04_Search_With_Product_Name_Child_Catefory() {
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Select category with computers - desktops");
		adminDashBoard.selectSearchByLabel("Category", "2");
		adminDashBoard.UnSelectToCheckboxByLabel("Search subcategories");
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();
		verifyEquals(adminDashBoard.getSizeProducts(), 1);
		log.info("Admin_01_Search_With_Product_Name: Get text product name ");
		verifyEquals(adminDashBoard.getInfoProduct("3"), "Lenovo IdeaCentre 600 All-in-One PC");
		log.info("Admin_01_Search_With_Product_Name: Get text price product ");
		verifyEquals(adminDashBoard.getInfoProduct("5"), "500");

	}

	public void Admin_05_Search_With_Product_Name_ManuFacTurer() {
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Select category with computers - desktops");
		adminDashBoard.selectSearchByLabel("Category", "0");
		log.info("Admin_01_Search_With_Product_Name: Unselect search by checkbox");
		adminDashBoard.UnSelectToCheckboxByLabel("Search subcategories");
		log.info("Admin_01_Search_With_Product_Name: Select manufacturer with Apple");
		adminDashBoard.selectSearchByLabel("Manufacturer", "1");
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();
		log.info("Admin_01_Search_With_Product_Name: Verify search no data");
		verifyEquals(adminDashBoard.getEmptyDataTable(), "No data available in table");

	}

	public void Admin_06_Search_With_Product_Go_Directly() {
		log.info("Admin_01_Search_With_Product_Name: Click to Catalog");
		adminDashBoard.clickToSidebarBylabel("Catalog");
		log.info("Admin_01_Search_With_Product_Name: Click to Products");
		adminDashBoard.clickToSidebarBylabel(" Products");
		log.info("Admin_01_Search_With_Product_Name: Input Go directly to product SKU");
		adminDashBoard.inputSearchByLabel("Go directly to product SKU", "LE_IC_600");
		log.info("Admin_01_Search_With_Product_Name: Click Go directly to product SKU");
		adminDashBoard.clickToButtonGoSKU();
		adminDashBoard.getEditProductDetail("Product name", "value");

	}

	@Test
	public void Admin_07_Create_New_Customer() {
		log.info("Admin_01_Search_With_Product_Name: Click to Customers");
		adminDashBoard.clickToSidebarBylabel("Customers");
		log.info("Admin_01_Search_With_Product_Name: Click to circle Customers");
		adminDashBoard.clickToSidebarBylabel(" Customers");
		adminCustomersPage = PageGeneratorManager.getAdminCustomerProduct(driver);
		log.info("Admin_01_Search_With_Product_Name: Click to add new");
		adminCustomersPage.clickToButtonAddNew();
		log.info("Admin_01_Search_With_Product_Name: Input to email with: " + email);
		adminCustomersPage.inputSearchByLabel("Email", email);
		adminCustomersPage.inputSearchByLabel("Password", password);

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}
}
