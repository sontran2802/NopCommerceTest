package PageUIs.nopcommerce.user;

public class HomePageUI {
	public static final String LINK_REGISTER = "XPATH=//a[@class='ico-register']";
	public static final String LINK_LOGOUT = "XPATH=////a[@class='ico-logout' and text()='Log out']";
	public static final String REGISTER_LOGIN_BUTTON = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT = "xpath=//a[@class='ico-account']";
	public static final String LINK_COMPUTERS = "xpath=//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[text()='Computers ']";
	public static final String LINK_SEARCH_FOOTER = "xpath=//div[@class='footer-block customer-service']//a[text()='Search']";
	public static final String BUTTON_ADD_TO_CART = "xpath=//a[text()='%s']/parent::h2//following-sibling::div[@class='add-info']//button[text()='%s']";
	public static final String HEADER_LOGO = "CSS=div.header-logo a";
	public static final String LINK_COMPARE_PRODUCT = "css=div#bar-notification a";
	public static final String LINK_RECENTLY_VIEW = "XPATH=//div[@class='footer']//a[text()='Recently viewed products']";

}
