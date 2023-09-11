package PageUIs.nopcommerce.user;

public class SortProductsPageUI {
	public static final String GET_NOTEBOOKS = "xpath=//ul[@class='sublist']//a[text()='Notebooks ']";
	public static final String SELECT_BY_TITLE = "xpath=//span[text()='%s']/following-sibling::select";
	public static final String PRODUCTS_TITLE = "xpath=//h2[@class='product-title']/a";
	public static final String PRODUCTS_PRICE = "xpath=//div[@class='product-item']//div[@class='prices']/span";
	public static final String PRODUCTS_ITEM = "css=div.product-item";
	public static final String LINK_NEXT_PAGE = "css=li.next-page>a";
	public static final String LINK_PREVIOUS_PAGE = "css=li.previous-page>a";

}
