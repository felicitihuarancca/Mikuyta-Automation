package com.automation.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Parent of the other classes of pages.
 * @author feliciti huarancca
 */
public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	public Logger log = Logger.getLogger(BasePage.class);
	
	/**
	 * Constructor.
	 * @param pDriver WebDriver
	 */
	public BasePage (WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 50);
		driver = pDriver;
	}

	/**
	 * Get the web driver wait.
	 * @return {@link WebDriverWait}
	 */
	protected WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Get the  web driver.
	 * @return {@link WebDriver}
	 */
	protected WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Close the web driver.
	 */
	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Wait element to be visible.
	 * @param element WebElement
	 */
	public void waitElementVisibility(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait element to be visible.
	 * @param elements list WebElement
	 */
	public void waitElementsVisibility(List<WebElement> elements) {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitElementInvisibility(WebElement element) {
		getWait().until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Get element text.
	 * @param element WebElement
	 * @return String
	 */
	public String getElementText(WebElement element) {
		waitElementVisibility(element);
		return element.getText();
	}

	public String getTextFromInput(WebElement element) {
		waitElementVisibility(element);
		return element.getAttribute("value");
	}

	/**
	 * Wait element and Set the values.
	 * @param element WebElement
	 * @param text	String text
	 */
	public void sendElementText(WebElement element, String text) {
		waitElementVisibility(element);
		element.click();
		element.sendKeys(text);
	}

	public void clearElementText(WebElement element) {
		waitElementVisibility(element);
		element.clear();
	}

	/**
	 * Wait element auntil it is clickable.
	 * @param element WebElement
	 */
	public void waitElementClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait and click the element.
	 * @param element WebElement
	 */
	public void clickElement(WebElement element){
		waitElementClickable(element);
		element.click();
	}

	/**
	 * Refresh current page.
	 */
	public void refreshPage() {
		getDriver().navigate().refresh();
	}

	/**
	 * Switch iFrame by id.
	 * @param element WebElement
	 */
	public void switchFrameById(WebElement element) {
		getDriver().switchTo().frame(element);
	}

	/**
	 * Switch to default iFrame.
	 */
	public void switchDefaultFrame() {
		getDriver().switchTo().defaultContent();
	}

	public boolean elementPresent(WebElement element) {
		return element.isDisplayed();
	}
}
