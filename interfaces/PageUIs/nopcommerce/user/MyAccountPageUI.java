package PageUIs.nopcommerce.user;

public class MyAccountPageUI {

	public static final String MYACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String TEXTBOX_BY_LABEL = "xpath=//input[@id='%s']";
	public static final String RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/parent::span/input";
	public static final String SELECT_TO_DATE_OF_BIRTH = "xpath=//div[@class='date-picker-wrapper']/select[@name='%s']";
	public static final String CHECK_SELECT_TO_DATE_OF_BIRTH = "xpath=//div[@class='date-picker-wrapper']/select[@name='%s']//option[@value='%s']";
	public static final String BUTTON_SAVE = "xpath=//button[@id='save-info-button']";
	public static final String BUTTON_SAVE_ADDRESS = "css=.save-address-button";
	public static final String BUTTON_ADD_NEW = "xpath=//button[text()='Add new']";
	public static final String BUTTON_CHANGE_PASSWORD = "xpath=//button[text()='Change password']";
	public static final String TEXTBOX_EDIT_ADDRESS_BY_LABEL = "xpath=//div[@class='edit-address']//label[text()='%s']/following-sibling::input";
	public static final String TEXTBOX_CHANGE_PASSWORD_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String LINK_ACCOUNT_LISTBOX = "xpath=//div[@class='master-wrapper-content']//ul[@class='list']//li//a[text()='%s']";
	public static final String SELECT_TO_ADDRESS_COUNTRY = "css=#Address_CountryId";
	public static final String SELECT_TO_ADDRESS_COUNTRY1 = "xpath=//select[@id='Address_CountryId']";
	public static final String GET_VALUE_ADDRESS_SUCCESS = "xpath=//ul[@class='info']//li[@class='%s']";
	public static final String BAR_NOTIFICATION_SUCCESS = "xpath=//p[@class='content' and text()='Password was changed']";
	public static final String CLOSE_BAR_NOTIFICATION_SUCCESS = "xpath=//p[@class='content' and text()='Password was changed']/following-sibling::span";
	public static final String LINK_LOGOUT = "XPATH=//a[@class='ico-logout' and text()='Log out']";

}
