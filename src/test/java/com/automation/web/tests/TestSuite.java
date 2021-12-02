package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Class for the Mikuyta test.
 * @author feliciti huarancca
 */
public class TestSuite extends BaseTest {

    User userCustomer = new User();
    User userCompany = new User();

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Test(description = "test register Mikuyta", priority = 1)
    public void testCaseRegisterCustomer_CPI01() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Start Register");
        SignUpPage signUpPage = homePage.clickRegisterLink();
        log.info("Select Customer");
        signUpPage.clickCustomer();
        Thread.sleep(2000);
        signUpPage.signUpCustomer(userCustomer.getFullname(), userCustomer.getEmail(), userCustomer.getPhone(), userCustomer.getIdentityNumber(), userCustomer.getUsername(), userCustomer.getPassword());
        log.info("Validate the registration");
        Assert.assertEquals(signUpPage.getUsernameText(),"", "THE USERNAME WAS EXPECTED TO BE EMPTY");
    }

    @Test(description = "test register Mikuyta", priority = 2)
    public void testCaseRegisterCompany_CPI02() throws InterruptedException {
        Thread.sleep(10000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Start Register");
        SignUpPage signUpPage = homePage.clickRegisterLink();
        log.info("Select Company");
        signUpPage.clickCompany();
        signUpPage.signUpCompany(userCompany.getFullname(), 10, "Mz. 33 lt 7", userCompany.getEmail(), userCompany.getPhone(), userCompany.getIdentityNumber(), userCompany.getUsername(), userCompany.getPassword());
        log.info("username: "+userCompany.getUsername());
        log.info("Validate the registration");
        Assert.assertEquals(signUpPage.getUsernameText(),"", "THE USERNAME WAS EXPECTED TO BE EMPTY");
    }

    @Test(description = "test log in Mikuyta as customer", priority = 3)
    public void testCaseLoginCustomer_CPI03() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getBrandText(), "MIKUYTA", "THE TEXT IS NOT AS EXPECTED");
        log.info("Start Log in");
        LoginPage loginPage = homePage.clickLoginLink();
        log.info("Logo is present");
        Assert.assertTrue(loginPage.logoImgIsDisplayed());
        log.info("username: " + userCustomer.getUsername());
        loginPage.logIn(userCustomer.getUsername(), userCustomer.getPassword());
        log.info("Validate log in successfully");
        Assert.assertEquals(loginPage.getRoleText(), "CLIENTE", "THE TEXT IS NOT AS EXPECTED");
        Thread.sleep(5000);
        log.info("Log out");
        loginPage.logout();
    }

    @Test(description = "test log in Mikuyta as company", priority = 4)
    public void testCaseLoginCompany_CPI04() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getBrandText(), "MIKUYTA", "THE TEXT IS NOT AS EXPECTED");
        log.info("Start Log in");
        LoginPage loginPage = homePage.clickLoginLink();
        log.info("Logo is present");
        Assert.assertTrue(loginPage.logoImgIsDisplayed());
        log.info("username: " + userCompany.getUsername());
        loginPage.logIn(userCompany.getUsername(), userCompany.getPassword());
        log.info("Validate log in successfully");
        Assert.assertEquals(loginPage.getRoleText(), "VENDEDOR", "THE TEXT IS NOT AS EXPECTED");
        Thread.sleep(5000);
        log.info("Log out");
        loginPage.logout();
    }

    @Test(description = "test select product in Mikuyta", priority = 5)
    public void testCaseSelectProduct_CPI05() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getBrandText(), "MIKUYTA", "THE TEXT IS NOT AS EXPECTED");
        log.info("Start Log in");
        LoginPage loginPage = homePage.clickLoginLink();
        log.info("Logo is present");
        Assert.assertTrue(loginPage.logoImgIsDisplayed());
        log.info("username: " + userCustomer.getUsername());
        loginPage.logIn(userCustomer.getUsername(), userCustomer.getPassword());
        OrderPage orderPage = loginPage.getOrderPage();
        String company = orderPage.getCompanyNameText();
        log.info("company: "+company);
        log.info("Select Company");
        orderPage.selectCompany();
        log.info("Validate information of the company");
        Assert.assertEquals(orderPage.getCompanyNameAtProducts(), "VENDEDOR "+company, "COMPANY NAME IS NOT AS EXPECTED");
        log.info("company: "+orderPage.getCompanyNameAtProducts());
        String product = orderPage.getProductNameText();
        String quantity = "2";
        String price = orderPage.getPriceText();
        log.info("Select Product");
        orderPage.selectProduct(quantity);
        Thread.sleep(10000);
        log.info("Select Cart icon");
        CartPage cartPage = orderPage.getCartPage();
        log.info("Validate information of the product");
        Thread.sleep(10000);
        Assert.assertEquals(cartPage.getProductName(), product, "THE PRODUCT NAME IS NOT AS EXPECTED");
        Assert.assertEquals(cartPage.getQuantity(), quantity, "THE QUANTITY IS NOT AS EXPECTED");
        log.info("Do Log out");
        loginPage.logout();
    }

    @Test(description = "test log out Mikuyta", priority = 6)
    public void testCaseLogout_CPI06() throws InterruptedException {
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getBrandText(), "MIKUYTA", "THE TEXT IS NOT AS EXPECTED");
        log.info("Start Log in");
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.logIn(userCustomer.getUsername(), userCustomer.getPassword());
        Thread.sleep(10000);
        log.info("Do Log out");
        loginPage.logout();
        log.info("Validate if log out successfully");
        Assert.assertTrue(loginPage.isLoginPresent());
    }
}
