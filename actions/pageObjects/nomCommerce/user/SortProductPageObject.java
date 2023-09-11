package pageObjects.nomCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.SortProductsPageUI;
import commons.BasePage;

public class SortProductPageObject extends BasePage {
	WebDriver driver;

	public SortProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void getNoteBooks() {
		waitForElementClickable(driver, SortProductsPageUI.GET_NOTEBOOKS);
		clickToElement(driver, SortProductsPageUI.GET_NOTEBOOKS);
		sleepInSecond(1);
	}

	public void chooseTypeSort(String labelSelect, String value) {
		waitForElementVisible(driver, SortProductsPageUI.SELECT_BY_TITLE, labelSelect);
		selectItemInDefaultDropDown(driver, SortProductsPageUI.SELECT_BY_TITLE, value, labelSelect);
		sleepInSecond(1);
	}

	public boolean checkSortWithLabel(String typeSort, String sortLabel) {
		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> listTitle;
		boolean check = true;
		if (sortLabel == "Name") {
			listTitle = getListElement(driver, SortProductsPageUI.PRODUCTS_TITLE);
			for (WebElement title : listTitle) {
				obtainedList.add(title.getText());

			}
		} else if (sortLabel == "Prices") {
			List<WebElement> listPrice = getListElement(driver, SortProductsPageUI.PRODUCTS_PRICE);
			for (WebElement price : listPrice) {
				String textPrice = price.getText().replace("$", "");

				obtainedList.add(textPrice);

			}

		}

		System.out.println("obtainedList: " + obtainedList);

		List sortedList = new ArrayList(obtainedList);
		if (typeSort.equals("Name: A to Z") || typeSort.equals("Price: Low to High")) {
			Collections.sort(sortedList);

		} else if (typeSort.equals("Name: Z to A") || typeSort.equals("Price: High to Low")) {

			Collections.sort(sortedList, Comparator.reverseOrder());
		}
		System.out.println("sortedList: " + sortedList);
		boolean ifSortedAscending = obtainedList.equals(sortedList);
		if (ifSortedAscending) {
			check = true;
		} else {
			check = false;
		}
		return check;

	}

	public int sizeProducts() {
		waitForElementVisible(driver, SortProductsPageUI.PRODUCTS_ITEM);
		return getElementSize(driver, SortProductsPageUI.PRODUCTS_ITEM);
	}

	public boolean isNextPage() {
		waitForElementVisible(driver, SortProductsPageUI.LINK_NEXT_PAGE);
		return isElementDisplayd(driver, SortProductsPageUI.LINK_NEXT_PAGE);
	}

	public void clickToNextPage() {
		waitForElementVisible(driver, SortProductsPageUI.LINK_NEXT_PAGE);
		clickToElement(driver, SortProductsPageUI.LINK_NEXT_PAGE);

	}

	public boolean isPreviousPage() {
		waitForElementVisible(driver, SortProductsPageUI.LINK_PREVIOUS_PAGE);
		return isElementDisplayd(driver, SortProductsPageUI.LINK_PREVIOUS_PAGE);
	}

	public boolean unDisplayNextPage() {
		// TODO Auto-generated method stub
		return isElementUnDisplayed(driver, SortProductsPageUI.LINK_NEXT_PAGE);
	}

//	public boolean checkSortWithPrice(String typeSort) {
//		ArrayList<String> obtainedList = new ArrayList<>();
//		boolean check = true;
//		List<WebElement> listPrice = getListElement(driver, SortProductsPageUI.PRODUCTS_PRICE);
//		for (WebElement price : listPrice) {
//			String textPrice = price.getText().replace("$", "");
//			System.out.println("textPrice " + textPrice);
//
//			obtainedList.add(textPrice);
//
//		}
//		List sortedListPrice = new ArrayList(obtainedList);
//		if (typeSort.equals("Price: Low to High")) {
//			Collections.sort(sortedListPrice);
//
//		} else if (typeSort.equals("Price: High to Low")) {
//
//			Collections.sort(sortedListPrice, Comparator.reverseOrder());
//		}
//		System.out.println("sortedList: " + sortedListPrice);
//		boolean ifSortedAscending = obtainedList.equals(sortedListPrice);
//		if (ifSortedAscending) {
//			check = true;
//		} else {
//			check = false;
//		}
//		return check;
//
//	}

}
