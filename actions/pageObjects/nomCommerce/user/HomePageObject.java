package pageObjects.nomCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.HomePageUI;
import PageUIs.nopcommerce.user.RegisterPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegister() {
		waitForElementClickable(driver, HomePageUI.LINK_REGISTER);
		clickToElement(driver, HomePageUI.LINK_REGISTER);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LOGIN_BUTTON);
		clickToElement(driver, HomePageUI.REGISTER_LOGIN_BUTTON);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	public boolean loginSuccess() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT);
		return isElementDisplayd(driver, HomePageUI.MY_ACCOUNT);

	}

	public MyAccountPageObject openMyAccountPage() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT);
		clickToElement(driver, HomePageUI.MY_ACCOUNT);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}

	public AdvancedSearchPageObject openAdvanceSearchPage() {
		waitForElementClickable(driver, HomePageUI.LINK_SEARCH_FOOTER);
		clickToElement(driver, HomePageUI.LINK_SEARCH_FOOTER);
		return PageGeneratorManager.getAdvancedSearchPage(driver);
	}

	public SortProductPageObject openSortProductsPage() {
		waitForElementClickable(driver, HomePageUI.LINK_COMPUTERS);
		clickToElement(driver, HomePageUI.LINK_COMPUTERS);
		return PageGeneratorManager.getSortProductsPage(driver);
	}

	public DetailPageObject clickAddToCart(String titleProduct, String nameButton) {
		waitForElementClickable(driver, HomePageUI.BUTTON_ADD_TO_CART, titleProduct, nameButton);
		clickToElement(driver, HomePageUI.BUTTON_ADD_TO_CART, titleProduct, nameButton);
		sleepInSecond(1);
		return PageGeneratorManager.getDetailProductPage(driver);

	}

	public void clickToHeaderLogo() {
		waitForElementClickable(driver, HomePageUI.HEADER_LOGO);
		clickToElement(driver, HomePageUI.HEADER_LOGO);

	}

	public CompareProductsPageObject openToCompareProduct() {
		waitForElementVisible(driver, HomePageUI.LINK_COMPARE_PRODUCT);
		clickToElement(driver, HomePageUI.LINK_COMPARE_PRODUCT);
		return PageGeneratorManager.getCompareProduct(driver);

	}

	public RecentlyViewProductPageObject openToRecentlyViewProducts() {
		waitForElementVisible(driver, HomePageUI.LINK_RECENTLY_VIEW);
		clickToElement(driver, HomePageUI.LINK_RECENTLY_VIEW);
		return PageGeneratorManager.getRencentlyViewProduct(driver);

	}

}
