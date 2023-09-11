package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

public class Employee_01_Add_Employee extends BaseTest {

	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		System.out.println("Run on " + browserName);
		log.info("Pre-condition - Step 01: Open browser");
		driver = getBrowserDriver(browserName);
		log.info("Pre-Condition - Step 02: Login with  admin role");

	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_new_01 - Step 01: Open employee list page");

		log.info("Add_new_01 - Step 02: Click to 'add' button");

		log.info("Add_new_01 - Step 03: Enter valid info to 'First Name' textbox");
		log.info("Add_new_01 - Step 04: Enter valid info to 'Last Name' textbox");
		log.info("Add_new_01 - Step 05: Get value of 'Employee ID'");
		log.info("Add_new_01 - Step 06: Click to 'Create Login  Details' checkbox");
		log.info("Add_new_01 - Step 04: Enter valid info to 'User Name' textbox");
		log.info("Add_new_01 - Step 04: Enter valid info to 'Password' textbox");
		log.info("Add_new_01 - Step 04: Enter valid info to 'Confirm Password' textbox");
		log.info("Add_new_01 - Step 04: Select 'Enable' value in 'Status' dropdown");
		log.info("Add_new_01 - Step 06: Click to 'Save' checkbox");
		log.info("Add_new_01 - Step 01: Open employee list page");
		log.info("Add_new_01 - Step 04: Enter valid info to 'Employee Name' textbox");
		log.info("Add_new_01 - Step 06: Click to 'Search' checkbox");
		log.info("Add_new_01 - Step 06: Verify employee information displayed at 'Result Table'");

	}

	@Test
	public void Employee_02_Add_New_Employee() {

	}

	@Test
	public void Employee_03_Add_New_Employee() {

	}

	@Test
	public void Employee_04_Add_New_Employee() {

	}

	@Test
	public void Employee_05_Add_New_Employee() {

	}

	@Test
	public void Employee_06_Add_New_Employee() {

	}

	@Test
	public void Employee_07_Add_New_Employee() {

	}

	@Test
	public void Employee_08_Add_New_Employee() {

	}

	@Test
	public void Employee_09_Add_New_Employee() {

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}
}
