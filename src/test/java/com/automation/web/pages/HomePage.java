package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the home page.
 * @author feliciti huarancca
 */
public class HomePage extends BasePage {

    @FindBy(css = "[data-test=\"brandName_lbl\"]")
    private WebElement brandNameLbl;

    @FindBy(css = "[data-test=\"signin_lnk\"]")
    private WebElement signinLnk;

    @FindBy(css = "[data-test=\"register_lnk\"]")
    private WebElement registerLnk;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Select the link Log In.
     */
    public LoginPage clickLoginLink() {
        clickElement(signinLnk);
        return new LoginPage(getDriver());
    }

    /**
     * Select the link Register.
     */
    public SignUpPage clickRegisterLink() {
        clickElement(registerLnk);
        return new SignUpPage(getDriver());
    }

    /**
     * Get Mikuyta text.
     * @return String
     */
    public String getBrandText() {
        return getElementText(brandNameLbl);
    }

}
