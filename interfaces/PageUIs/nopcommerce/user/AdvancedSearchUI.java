package PageUIs.nopcommerce.user;

import org.openqa.selenium.WebDriver;

public class AdvancedSearchUI {
	public static final String BUTTON_SEARCH = "XPATH=//div[@class='page-body']//button[text()='Search']";
	public static final String CHECKBOX_BY_LABEL = "XPATH=//label[text()='%s']/parent::div/input";
	public static final String SELECT_BY_LABEL = "XPATH=//div[@id='advanced-search-block']//label[text()='%s']/following-sibling::select";
	public static final String ERROR_MESSAGE_LESS_3_CHARACTERS = "XPATH=//div[@class='products-wrapper']/div[@class='warning']";
	public static final String NOT_FOUND_PRODUCTS = "XPATH=//div[@class='products-wrapper']/div[@class='no-result']";
	public static final String ISDISPLAY_PRODUCTS_WITH_TEXT = "XPATH=//h2[@class='product-title']/a[text()='%s']";

	public static final String TEXTBOX_SEARCH_KEYWORD = "XPATH=//div[@class='basic-search']//label[text()='Search keyword:']/following-sibling::input";

}
