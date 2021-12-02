package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class for interact with the cart page.
 * @author feliciti huarancca
 */
public class CartPage extends BasePage{

    @FindBy(css = "[data-test=\"tbl_productName\"]")
    private List<WebElement> productName;

    @FindBy(css = "[data-test=\"tbl_quantity\"]")
    private List<WebElement> quantity;

    @FindBy(css = "[data-test=\"tbl_price\"]")
    private List<WebElement> price;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CartPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getProductName() {
        return getElementText(productName.get(0));
    }

    public String getQuantity() {
        return getElementText(quantity.get(0));
    }

    public String getPrice() {
        return getElementText(price.get(0));
    }
}
