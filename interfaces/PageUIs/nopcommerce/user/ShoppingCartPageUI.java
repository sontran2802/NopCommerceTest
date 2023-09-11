package PageUIs.nopcommerce.user;

public class ShoppingCartPageUI {
	public static final String LINK_SHOPPING_CART = "CSS=li#topcartlink>a";
	public static final String SUCCESS_ADD_TO_CART = "CSS=div.mini-shopping-cart div.count";
	public static final String GET_SUB_TOTAL = "CSS=div.mini-shopping-cart div.totals";
	public static final String EDIT_ITEM = "CSS=div.edit-item>a";
	public static final String GET_PRICE_PRODUCT = "CSS=span.product-unit-price";
	public static final String GET_TOTAL_PRODUCT = "CSS=span.product-subtotal";
	public static final String REMOVE_FROM_CART = "CSS=TD.remove-from-cart";
	public static final String SHOPPING_CART_EMPTY = "CSS=div.no-data";
	public static final String INPUT_QUANTITY_CART = "CSS=input.qty-input";
	public static final String BUTTON_TO_LABEL = "XPATH=//button[text()='%s']";
	public static final String BUTTON_CHECKOUT_TO_LABEL = "XPATH=//h2[text()='%s']/parent::div/parent::li//button[text()='Continue']";
	public static final String CHECKBOX_AGREE_CHECKOUT = "CSS=div.terms-of-service>input";
	public static final String INPUT_TO_BILLING_ADDRESS_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String SELECT_TO_BILLING_ADDRESS_BY_LABEL = "xpath=//label[text()='%s']/following-sibling::select";
	public static final String RADIO_TO_ORDER_BY_LABEL = "xpath=//label[text()='%s']/parent::div/input";
	public static final String TEXT_PAYMENT_INFORMATION = "xpath=//p[text()='P.S. You can edit this text from admin panel.']";
	public static final String TEXT_SUCCESS_BY_LABEL = "xpath=//strong[text()='%s']/parent::div/parent::div//li[@class='%s']";
	public static final String TEXT_CART_TOTAL_BY_LABEL = "xpath=//label[text()='%s']/parent::td/following-sibling::td";
	public static final String GET_TITLE_ORDER_SUCCESS = "css=div.master-column-wrapper div.title>strong";
	public static final String GET_NUMBER_ORDER_SUCCESS = "css=div.master-wrapper-content div.order-number>strong";
	public static final String CLICK_MY_ACCOUNT_LINK = "XPATH=//div[@class='header-links']//a[text()='My account']";
	public static final String BUTTON_CONFIRM_ORDER = "XPATH=//h2[text()='Confirm order']/parent::div/parent::li//button[text()='Confirm']";

}
