package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;

public class User_03_My_Account extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String emailAddress, firstName, lastName, password, companyName, cityName, addressName1, addressName2,
			postalCode, phoneNumber, faxNumber, newPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccount;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.PORTAL_PAGE_URL);

		emailAddress = "Automation" + generateFakeNumber() + "@gmail.com";
		firstName = "Autonmation";
		lastName = "FC";
		password = "123456";
		companyName = "Automation FC";
		cityName = "Ho Chi Minh";
		addressName1 = "123 Ton Duc Thang";
		addressName2 = "551 Ton Duc Thang";
		postalCode = "11415";
		phoneNumber = "+84 9412141";
		faxNumber = "412141";
		newPassword = "123457";
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

	}

	@Test
	public void Myaccount_01_Customer_info() {
		log.info("User_03_My_account - Step 01: Click link my account");
		myAccount = homePage.openMyAccountPage();
		log.info("User_03_My_account - Step 02: Click radio button gender");
		myAccount.clickToRadioButtonByLabel("Male");
		log.info("User_03_My_account - Step 02: Input to first name with value: " + firstName);
		myAccount.inputToLable("FirstName", firstName);

		log.info("User_03_My_account - Step 02: Input to last name with value: " + lastName);
		myAccount.inputToLable("LastName", lastName);
		log.info("User_03_My_account - Step 02: Select date of birth");
		myAccount.selectToDateOfBirth("DateOfBirthDay", "15");
		log.info("User_03_My_account - Step 02: Select month of birth");
		myAccount.selectToDateOfBirth("DateOfBirthMonth", "2");
		log.info("User_03_My_account - Step 02: Select year of birth");
		myAccount.selectToDateOfBirth("DateOfBirthYear", "1997");
		log.info("User_03_My_account - Step 02: Input to email with value: " + emailAddress);
		myAccount.inputToLable("Email", emailAddress);
		log.info("User_03_My_account - Step 02: Input to company name with value: " + companyName);
		myAccount.inputToLable("Company", companyName);
		log.info("User_03_My_account - Step 03: Click to button save ");
		myAccount.clickToButtonSave();
		log.info("User_03_My_account - Step 04: Verify radio gender update success");
		verifyTrue(myAccount.checkGenderSelected("Male"));
		log.info("User_03_My_account - Step 04: Verify first name update success");
		verifyEquals(myAccount.getValueSuccess("FirstName", "value"), firstName);
		log.info("User_03_My_account - Step 04: Verify last name update success");
		verifyEquals(myAccount.getValueSuccess("LastName", "value"), lastName);

		log.info("User_03_My_account - Step 04: Verify date of birth selected");
		verifyTrue(myAccount.checkDateOfBirthSelected("DateOfBirthDay", "15"));
		log.info("User_03_My_account - Step 04: Verify month of birth selected");
		verifyTrue(myAccount.checkDateOfBirthSelected("DateOfBirthMonth", "2"));
		log.info("User_03_My_account - Step 04: Verify year of birth selected");
		verifyTrue(myAccount.checkDateOfBirthSelected("DateOfBirthYear", "1997"));
		log.info("User_03_My_account - Step 04: Verify email update success");
		verifyEquals(myAccount.getValueSuccess("Email", "value"), emailAddress);

		log.info("User_03_My_account - Step 04: Verify company name update success");
		verifyEquals(myAccount.getValueSuccess("Company", "value"), companyName);

	}

	@Test
	public void Myaccount_02_Customer_info_Addresses() {
		log.info("User_03_My_account - Step 01: Click to link addresses");
		myAccount.clickToLinkAccountListbox("Addresses");
		log.info("User_03_My_account - Step 02: Click to button add new ");
		myAccount.clickToButtonAddNew();
		log.info("User_03_My_account - Step 03: Input to first name");
		myAccount.inputToLabelEditAddresses("First name:", firstName);
		log.info("User_03_My_account - Step 03: Input to last name");
		myAccount.inputToLabelEditAddresses("Last name:", lastName);
		log.info("User_03_My_account - Step 03: Input to email");
		myAccount.inputToLabelEditAddresses("Email:", emailAddress);
		log.info("User_03_My_account - Step 03: Input to company");
		myAccount.inputToLabelEditAddresses("Company:", companyName);
		log.info("User_03_My_account - Step 03: Select to country");
		myAccount.selectToCountry("1");
		log.info("User_03_My_account - Step 03: Select to province");
		log.info("User_03_My_account - Step 03: Input to city");
		myAccount.inputToLabelEditAddresses("City:", cityName);
		log.info("User_03_My_account - Step 03: Input to address 1");
		myAccount.inputToLabelEditAddresses("Address 1:", addressName1);
		log.info("User_03_My_account - Step 03: Input to address 2");
		myAccount.inputToLabelEditAddresses("Address 2:", addressName2);
		log.info("User_03_My_account - Step 03: Input to postal code");
		myAccount.inputToLabelEditAddresses("Zip / postal code:", postalCode);
		log.info("User_03_My_account - Step 03: Input to phone number");
		myAccount.inputToLabelEditAddresses("Phone number:", phoneNumber);
		log.info("User_03_My_account - Step 03: Input to fax number");
		myAccount.inputToLabelEditAddresses("Fax number:", " " + faxNumber);
		log.info("User_03_My_account - Step 04: Click to button save");
		myAccount.clickToSaveAddressButton();
		log.info("User_03_My_account - Step 05: Verify last name + first name update success");
		verifyEquals(myAccount.getValueAddress("name"), firstName + " " + lastName);

		log.info("User_03_My_account - Step 05: Verify email update success");
		verifyEquals(myAccount.getValueAddress("email"), "Email: " + emailAddress);
		System.out.println(myAccount.getValueAddress("email"));

		log.info("User_03_My_account - Step 05: Verify phone number update success");
		verifyEquals(myAccount.getValueAddress("phone"), "Phone number: " + phoneNumber);
		log.info("User_03_My_account - Step 05: Verify fax number update success");
		verifyEquals(myAccount.getValueAddress("fax"), "Fax number: " + faxNumber);
		log.info("User_03_My_account - Step 05: Verify company update success");
		verifyEquals(myAccount.getValueAddress("company"), companyName);
		log.info("User_03_My_account - Step 05: Verify address 1 update success");
		verifyEquals(myAccount.getValueAddress("address1"), addressName1);
		log.info("User_03_My_account - Step 05: Verify address 2 update success");
		verifyEquals(myAccount.getValueAddress("address2"), addressName2);
		log.info("User_03_My_account - Step 05: Verify city state zip update success");
		verifyEquals(myAccount.getValueAddress("city-state-zip"), cityName + ", " + postalCode);
		log.info("User_03_My_account - Step 05: Verify country update success");
		verifyEquals(myAccount.getValueAddress("country"), "United States");

	}

	@Test
	public void Myaccount_03_Change_Password() {
		log.info("User_03_My_account - Step 01: Click to link change password");

		myAccount.clickToLinkAccountListbox("Change password");
		log.info("User_03_My_account - Step 03: Input to old password");
		myAccount.inputToChangePasswordWithLabel("Old password:", password);
		log.info("User_03_My_account - Step 03: Input to new password");
		myAccount.inputToChangePasswordWithLabel("New password:", newPassword);
		log.info("User_03_My_account - Step 03: Input to confirm password");
		myAccount.inputToChangePasswordWithLabel("Confirm password:", newPassword);
		log.info("User_03_My_account - Step 03: Click to button change password");
		myAccount.clickToButtonChangePassword();
		log.info("User_03_My_account - Step 04: Verify bar notification success");
		verifyTrue(myAccount.isNotificationSuccess());
		log.info("User_03_My_account - Step 04: Close bar notification success");
		myAccount.closeBarNotification();

		log.info("User_03_My_account - Step 05: Click to log out link");
		homePage = myAccount.clickToLogOutLink();
		log.info("User_03_My_account - Step 06: Click to log in link");
		loginPage = homePage.clickToLoginLink();
		log.info("User_03_My_account - Step 07: Input to email address");
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_03_My_account - Step 07: Input to old password");
		loginPage.inputToPasswordTextBox(password);
		log.info("User_03_My_account - Step 08: Click to button log in");
		loginPage.clickToButtonLogin();

		log.info("User_03_My_account - Step 08: Verify log in failed");
		verifyEquals(loginPage.getErrorMessageExistingPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		log.info("User_03_My_account - Step 09: Input to email address");
		System.out.println(loginPage.getErrorMessageExistingPassword());
		loginPage.inputToEmailTextBox(emailAddress);
		log.info("User_03_My_account - Step 09: Input to new password");
		loginPage.inputToPasswordTextBox(newPassword);
		log.info("User_03_My_account - Step 08: Click to button log in");
		homePage = loginPage.clickToButtonLogin();
		log.info("User_03_My_account - Step 10: Verify log in success");
		verifyTrue(homePage.loginSuccess());
	}

	public void Myaccount_04_Product_Reviews() {

	}

	@AfterClass
	public void affterClass() {
		driver.quit();

	}
}
