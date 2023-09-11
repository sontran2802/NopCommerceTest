package PageUIs.nopcommerce.user;

public class DetailPageUI {
	public static final String OVERVIEW_BUTTON = "xpath=//div[@class='overview']//button[text()='%s']";
	public static final String LINK_SHOPPING_CART = "CSS=li#topcartlink>a";
	public static final String INPUT_QUANTITY_ITEM = "CSS=input#product_enteredQuantity_1";
	public static final String BAR_NOTIFICATION_LINK = "xpath=//div[@id='bar-notification']//a";
	public static final String SELECT_PRODUCT_BY_LABEL = "xpath=//label[text()=' %s ']/parent::dt/following-sibling::dd/select";
	public static final String RADIO_CHECKBOX_PRODUCT_BY_LABEL = "xpath=//label[text()=' %s ']/parent::dt/following-sibling::dd//label[text()='%s']/parent::li/input";

}
