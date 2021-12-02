package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Class for interact with the signup page.
 * @author feliciti huarancca
 */
public class SignUpPage extends BasePage {

    @FindBy(css = "[data-test=\"company_btn\"]")
    private WebElement customerBtn;

    @FindBy(css = "[data-test=\"customer_btn\"]")
    private WebElement companyBtn;

    @FindBy(css = "[data-test=\"fullname_txt\"]")
    private WebElement fullnameTxt;

    @FindBy(css = "[data-test=\"email_txt\"]")
    private WebElement emailTxt;

    @FindBy(css = "[data-test=\"phone_txt\"]")
    private WebElement phoneTxt;

    @FindBy(css = "[data-test=\"identityType_txt\"]")
    private WebElement identityNumberTxt;

    @FindBy(css = "[data-test=\"username_txt\"]")
    private WebElement usernameTxt;

    @FindBy(css = "[data-test=\"password_txt\"]")
    private WebElement passwordTxt;

    @FindBy(css = "[data-test=\"district_cmb\"]")
    private WebElement districtCmb;

    @FindBy(css = "[data-test=\"address_txt\"]")
    private WebElement addressTxt;

    @FindBy(css = "[data-test=\"register_btn\"]")
    private WebElement registerBtn;

    /**
     * Constructor.
     * @param driver WebDriver
     */
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sign Up.
     * @param fullname String set first name
     * @param email String set email
     * @param phone String set phone
     * @param identityNumber String set identity number
     * @param username String set username
     * @param password String set password
     */
    public void signUpCustomer(String fullname, String email, String phone, String identityNumber, String username, String password) throws InterruptedException {
        log.info("Set values");
        sendElementText(fullnameTxt, fullname);
        sendElementText(emailTxt, email);
        sendElementText(phoneTxt, phone);
        sendElementText(identityNumberTxt, identityNumber);
        sendElementText(usernameTxt, username);
        log.info("username"+getUsernameText());
        sendElementText(passwordTxt, password);
        log.info("Click Sign Up");
        Thread.sleep(1000);
        clickElement(registerBtn);
    }

    public void clickCustomer() {
        customerBtn.click();
    }

    public void signUpCompany(String fullname, int district, String address, String email, String phone, String identityNumber, String username, String password) throws InterruptedException {
        log.info("Set values");
        Select districtDropdown = new Select(districtCmb);
        waitElementVisibility(fullnameTxt);
        sendElementText(fullnameTxt, fullname);
        districtDropdown.selectByIndex(district);
        sendElementText(addressTxt, address);
        sendElementText(emailTxt, email);
        sendElementText(phoneTxt, phone);
        sendElementText(identityNumberTxt, identityNumber);
        sendElementText(usernameTxt, username);
        log.info("username"+getUsernameText());
        sendElementText(passwordTxt, password);
        log.info("Click Sign Up");
        Thread.sleep(1000);
        clickElement(registerBtn);
    }

    public void clickCompany() {
        companyBtn.click();
    }

    public String getUsernameText() {
        return getTextFromInput(usernameTxt);
    }
}
