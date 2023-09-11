package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nomCommerce.user.AdvancedSearchPageObject;
import pageObjects.nomCommerce.user.CompareProductsPageObject;
import pageObjects.nomCommerce.user.DetailPageObject;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nomCommerce.user.LoginPageObject;
import pageObjects.nomCommerce.user.MyAccountPageObject;
import pageObjects.nomCommerce.user.OrderProductPageObject;
import pageObjects.nomCommerce.user.RecentlyViewProductPageObject;
import pageObjects.nomCommerce.user.RegisterPageObject;
import pageObjects.nomCommerce.user.ShoppingCartPageObject;
import pageObjects.nomCommerce.user.SortProductPageObject;
import pageObjects.nomCommerce.user.WishlistPageObject;
import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashBoardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static HomePageObject getUserHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getUserLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static MyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashBoardPageObject getAdmindDashboardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}

	public static AdvancedSearchPageObject getAdvancedSearchPage(WebDriver driver) {
		return new AdvancedSearchPageObject(driver);
	}

	public static SortProductPageObject getSortProductsPage(WebDriver driver) {
		return new SortProductPageObject(driver);
	}

	public static DetailPageObject getDetailProductPage(WebDriver driver) {

		return new DetailPageObject(driver);
	}

	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static CompareProductsPageObject getCompareProduct(WebDriver driver) {
		return new CompareProductsPageObject(driver);
	}

	public static RecentlyViewProductPageObject getRencentlyViewProduct(WebDriver driver) {
		return new RecentlyViewProductPageObject(driver);
	}

	public static ShoppingCartPageObject getShoppingCart(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}

	public static OrderProductPageObject getOrderProduct(WebDriver driver) {
		return new OrderProductPageObject(driver);
	}

	public static AdminCustomersPageObject getAdminCustomerProduct(WebDriver driver) {
		return new AdminCustomersPageObject(driver);
	}

}
