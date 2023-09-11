package PageUIs.nopcommerce.admin;

public class AdminDashboardPageUI {

	public static final String DASHBOARD_HEADER = "xpath=//h1[contains(text(),'Dashboard')]";
	public static final String LINK_SIDEBAR_BY_LABEL = "xpath=//p[contains(text(),'%s')]/parent::a/i";
	public static final String BUTTON_SEARCH_PRODUCT = "css=button#search-products";
	public static final String BUTTON_GO_BY_SKU = "css=button#go-to-product-by-sku";
	public static final String GET_TEXT_INFO_PRODUCT = "XPATH=//tr/td[%s]";
	public static final String GET_SIZE_PRODUCTS = "css=table#products-grid tbody tr";
	public static final String INPUT_SEARCH_BY_LABEL = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div//input";
	public static final String SELECT_SEARCH_BY_LABEL = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div/select";
	public static final String GET_EMPTY_DATA_TABLE = "CSS=td.dataTables_empty";

}
