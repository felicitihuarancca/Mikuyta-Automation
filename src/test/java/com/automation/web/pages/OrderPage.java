package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Class for interact with the order page.
 * @author feliciti huarancca
 */
public class OrderPage extends BasePage{

    @FindBy(css = "[data-test=\"listCompany_lnk\"]")
    private WebElement listCompanyLink;

    @FindBy(css = "[data-test=\"searchCompany_lbl\"]")
    private WebElement searchCompanyLbl;

    @FindBy(css = "[data-test=\"searchCompany_txt\"]")
    private WebElement searchCompanyTxt;

    @FindBy(css = "[data-test=\"visit_lnk\"]")
    private List<WebElement> visitLink;

    @FindBy(css = "[data-test=\"fullname_lbl\"]")
    private List<WebElement> fullnameLbl;

    @FindBy(css = "[data-test=\"quantity_txt\"]")
    private List<WebElement> quantityTxt;

    @FindBy(css = "[data-test=\"add_btn\"]")
    private List<WebElement> addBtn;

    @FindBy(css = "[data-test=\"productName_lbl\"]")
    private List<WebElement> productNameLbl;

    @FindBy(css = "[data-test=\"price_lbl\"]")
    private List<WebElement> priceLbl;

    @FindBy(css = "[data-test=\"cart_lnk\"]")
    private WebElement cartLink;

    @FindBy(css = "[data-test=\"company_name\"]")
    private WebElement companyNamePrd;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public OrderPage(WebDriver pDriver) {
        super(pDriver);
    }

    public void selectCompany() {
        waitElementsVisibility(visitLink);
        clickElement(visitLink.get(0));
    }

    public void selectProduct(String quantity) {
        clearElementText(quantityTxt.get(0));
        sendElementText(quantityTxt.get(0), quantity);
        clickElement(addBtn.get(0));
    }

    public CartPage getCartPage() {
        clickElement(cartLink);
        return new CartPage(getDriver());
    }

    public String getSearchText() {
        return getElementText(searchCompanyLbl);
    }

    public String getCompanyNameText() {
        return getElementText(fullnameLbl.get(0));
    }

    public String getProductNameText() {
        return getElementText(productNameLbl.get(0));
    }

    public String getPriceText() {
        return getElementText(priceLbl.get(0));
    }

    public String getCompanyNameAtProducts() {
        return getElementText(companyNamePrd);
    }
}
