package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObjects.nopCommerce.admin.AdminDashBoardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class Admin_01_Search_Products extends BaseTest {

	private WebDriver driver;
	private AdminDashBoardPageObject adminDashBoard;
	private AdminLoginPageObject adminLoginPage;
	String productName;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		System.out.println("Run on " + browserName);
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashBoard = adminLoginPage.clickToLoginButton();
		productName = "Lenovo IdeaCentre 600All-in-One PC";

	}

	@Test
	public void Admin_01_Search_With_Product_Name() {
		log.info("Admin_01_Search_With_Product_Name: Click to Catalog");
		adminDashBoard.clickToSidebarBylabel("Catalog");
		log.info("Admin_01_Search_With_Product_Name: Click to Products");
		adminDashBoard.clickToSidebarBylabel(" Products");
		log.info("Admin_01_Search_With_Product_Name: Input to product name with: " + productName);

		adminDashBoard.inputSearchByLabel("Product name", productName);
		log.info("Admin_01_Search_With_Product_Name: Click button search product");
		adminDashBoard.clickButtonSearchProduct();

	}

	@Test
	public void Admin_02_Search_With_Product_Name_Catefory() {

	}

	@Test
	public void Admin_03_Search_With_Product_Name_Catefory_Checked() {

	}

	@Test
	public void Admin_04_Search_With_Product_Name_Child_Catefory() {

	}

	@Test
	public void Admin_05_Search_With_Product_Name_ManuFacTurer() {

	}

	@Test
	public void Admin_06_Search_With_Product_Go_Directly() {

	}

	@Test
	public void Admin_07_Create_New_Customer() {

	}
}
