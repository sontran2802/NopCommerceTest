package com.jquery.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.Jquery.HomePageObject;

public class Level10_Datatable_Datagirid {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		homePage = pageObjects.Jquery.PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Table_01_Paging() {
		homePage.openAllPagingByPageNumber();
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));

	}

	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLable("Females", "16538000");
		homePage.enterToHeaderTextboxByLable("Country", "Arab Rep of Egypt");
		homePage.enterToHeaderTextboxByLable("Males", "36009309");
		homePage.enterToHeaderTextboxByLable("Total", "83202680");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
