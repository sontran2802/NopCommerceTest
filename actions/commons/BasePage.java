package commons;

import java.awt.Color;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Colors;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopcommerce.user.BasePageUI;
import net.bytebuddy.implementation.bytecode.Throw;
import pageObjects.nomCommerce.user.HomePageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;

public class BasePage {
	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSoure(WebDriver driver) {
		return driver.getPageSource();
	}

	public void bakToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWate = new WebDriverWait(driver, longTimeout);
		return explicitWate.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptArlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancletArlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public String getTextArlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		return alert.getText();
	}

	public void sendKeyToArlert(WebDriver driver, String textValue) {
		Alert alert = waitForAlertPresence(driver);
		alert.sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}

	}

	public void switchToWindowByITitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			driver.switchTo().window(id);
			String actuaTitle = driver.getTitle();
			if (actuaTitle.equals(tabTitle)) {

				break;
			}
		}

	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {

			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
				break;
			}
			driver.switchTo().window(parentID);
		}

	}

	public By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));

		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=")
				|| locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=")
				|| locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=")
				|| locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;

	}

	private String getDynamicXpath(String locatorType, String... value) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")
				|| locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[]) value);
		}

		return locatorType;
	}

	public WebElement getElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getElement(driver, locatorType).click();
	};

	public void clearToInput(WebDriver driver, String locatorType, String... dynamicValue) {
		getElement(driver, getDynamicXpath(locatorType, dynamicValue)).clear();
	};

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		getElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
	};

	public String getTextElement(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).getText();
	};

	public String getTextElement(WebDriver driver, String locatorType, String... dynamicValue) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValue)).getText();
	};

	public void sendKeysToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendKeysToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getElement(driver, locatorType));
		select.selectByValue(textItem);

	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValue) {
		Select select = new Select(getElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		select.selectByValue(textItem);

	}

	public String getSelectedItemDefaultDropDown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();

	}

	public Boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();

	}

	public void selectItemCustomDropDown(WebDriver driver, String xpathLocator, String childXpath, String parentXpath,
			String expectedText) {
		getElement(driver, parentXpath).click();
		sleepInSecond(1);
		WebDriverWait explitiWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explitiWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("argument[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}

	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String typeLocator, String attributeName,
			String... dynamicValue) {
		return getElement(driver, getDynamicXpath(typeLocator, dynamicValue)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String convertRgbaToHexa(String rgbaValue) {
		return org.openqa.selenium.support.Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListElement(driver, locatorType).size();

	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValue) {
		return getListElement(driver, getDynamicXpath(locatorType, dynamicValue)).size();

	}

	public void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void checkToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator, String... dynamicValue) {
		WebElement element = getElement(driver, getDynamicXpath(xpathLocator, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator, String... dynamicValue) {
		WebElement element = getElement(driver, getDynamicXpath(xpathLocator, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}

	}

	public void unCheckToDefaultCheckBoxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}

	}

	public Boolean isElementDisplayd(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isDisplayed();
	}

	public Boolean isElementDisplayd(WebDriver driver, String locatorType, String... dynamicValue) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValue)).isDisplayed();
	}

	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		overrideImlictiTimeout(driver, shortTimeout);
		List<WebElement> elements = getListElement(driver, locator);
		overrideImlictiTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void overrideImlictiTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public Boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();

	}

	public Boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();

	}

	public Boolean isElementSelected(WebDriver driver, String xpathLocator, String... dynamicValue) {
		return getElement(driver, getDynamicXpath(xpathLocator, dynamicValue)).isSelected();

	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathLocator)));

	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));

	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathLocator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathLocator)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, xpathLocator)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListElement(driver, getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void pressSendKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locatorType), key).perform();

	}

	public void pressSendKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getDynamicXpath(locatorType, dynamicValues), key).perform();

	}

	public HomePageObject clickToLogoutLinkAtUser(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);
		System.out.println(BasePageUI.LOGOUT_LINK_AT_USER.substring(5));
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	private long longTimeout = 30;
	private long shortTimeout = 5;
}
