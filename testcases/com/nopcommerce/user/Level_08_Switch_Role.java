package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;
import pageObjects.nopCommerce.admin.AdminDashBoardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class Level_08_Switch_Role {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private HomePageObject userHomePage;
	private RegisterPageObject registerPage;
	private LoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashboardPage;
	private MyAccountPageObject userCustomerInforPage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		userEmailAddress = "automation@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		driver.get("https://demo.nopcommerce.com/");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void Role_01_User() {
		userLoginPage = userHomePage.clickToLoginLink();

		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.loginSuccess());
//		Home Page --> Customer Infor
		userCustomerInforPage = userHomePage.openMyAccountPage();
//		Customer Infor click logout --> Home Page
		userHomePage = userCustomerInforPage.clickToLogoutLinkAtUser(driver);

//		Open Admin Page
		userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
//		Login Admin Page
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplay());
//		Logout Admin Page
		sleepInSecond(1);
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdmin(driver);

	}

	@Test
	public void Role_02_Admin() {
		adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userLoginPage = userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.loginSuccess());

	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}

}
