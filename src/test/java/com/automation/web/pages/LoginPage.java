package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for interact with the login page.
 * @author feliciti huarancca
 */
public class LoginPage extends BasePage {

    @FindBy(css = "[data-test=\"logo_img\"]")
    private WebElement logoImg;

    @FindBy(css = "[data-test=\"username_txt\"]")
    private WebElement usernameField;

    @FindBy(css = "[data-test=\"password_txt\"]")
    private WebElement passwordField;

    @FindBy(css = "[data-test=\"login_btn\"]")
    private WebElement loginButton;

    @FindBy(css = "[data-test=\"orders_lnk\"]")
    private WebElement ordersLnk;

    @FindBy(css = "[data-test=\"logout_btn\"]")
    private WebElement logoutBtn;

    @FindBy(css = "[data-test=\"role_btn\"]")
    private WebElement roleBtn;

    @FindBy(css = "[data-test=\"listCompany_lnk\"]")
    private WebElement listCompanyLink;

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Log In.
     * @param username String set username or email
     * @param password String set password
     */
    public void logIn(String username, String password) {
        log.info("Set username value");
        sendElementText(usernameField, username);
        log.info("Set password value");
        sendElementText(passwordField, password);
        log.info("Click Log In");
        waitElementVisibility(loginButton);
        clickElement(loginButton);
    }

    /**
     * Get a true or false if the element is displayed.
     * @return boolean
     */
    public boolean logoImgIsDisplayed() {
        return logoImg.isDisplayed();
    }

    /**
     * Get a true or false if the element is displayed.
     * @return boolean
     */
    public boolean ordersLinkIsDisplayed() {
        return ordersLnk.isDisplayed();
    }

    /**
     * Log out.
     */
    public void logout() {
        clickElement(logoutBtn);
    }

    public String getRoleText() {
        return getElementText(roleBtn);
    }

    public OrderPage getOrderPage() {
        clickElement(listCompanyLink);
        return new OrderPage(getDriver());
    }

    public boolean isLoginPresent() {
        return elementPresent(loginButton);
    }
}
