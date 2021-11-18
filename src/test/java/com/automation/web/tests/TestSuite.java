package com.automation.web.tests;

import com.automation.web.data.Data;
import com.automation.web.data.User;
import com.automation.web.pages.HomePage;
import com.automation.web.pages.LoginPage;
import com.automation.web.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Class for the Mikuyta test.
 * @author feliciti huarancca
 */
public class TestSuite extends BaseTest {

    @AfterMethod
    @Parameters({"url"})
    public void launchHomePage(String url) {
        driver.getDriver().get(url);
    }

    @Test(description = "test register Mikuyta", priority = 1, dataProviderClass = Data.class, dataProvider = "registerdata")
    public void testCaseRegisterCustomer_CPI01(User user) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Start Register");
        SignUpPage signUpPage = homePage.clickRegisterLink();
        log.info("Select Customer");
        signUpPage.clickCustomer();
        signUpPage.signUpCustomer(user.getFullname(), user.getEmail(), user.getPhone(), user.getIdentityNumber(), user.getUsername(), user.getPassword());

    }

    @Test(description = "test register Mikuyta", priority = 2, dataProviderClass = Data.class, dataProvider = "registerdata")
    public void testCaseRegisterCompany_CPI02(User user) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        log.info("Start Register");
        SignUpPage signUpPage = homePage.clickRegisterLink();
        log.info("Select Customer");
        signUpPage.clickCompany();
        signUpPage.signUpCompany(user.getFullname(), "Seleccione", "Mz. 33 lt 7", user.getEmail(), user.getPhone(), user.getIdentityNumber(), user.getUsername(), user.getPassword());

    }

    @Test(description = "test log in Mikuyta", priority = 3, dataProviderClass = Data.class, dataProvider = "logindata")
    public void testCaseLoginCustomer_CPI03(User user) throws InterruptedException {
        Thread.sleep(1000);
        log.info("Get Home Page");
        HomePage homePage = getHomePage();
        Assert.assertEquals(homePage.getBrandText(), "MIKUYTA", "THE TEXT IS NOT AS EXPECTED");
        log.info("Start Log in");
        LoginPage loginPage = homePage.clickLoginLink();
        log.info("Logo is present");
        Assert.assertTrue(loginPage.logoImgIsDisplayed());
        loginPage.logIn(user.getUsername(), user.getPassword());
        Assert.assertTrue(loginPage.ordersLinkIsDisplayed(), "ORDERS LINK IS NOT DISPLAYED");
        Thread.sleep(5000);
        log.info("Log out");
        loginPage.logout();
    }

    @Test
    public void testCaseLoginCompany_CPI04() {
        log.info("Get Home Page");
        log.info("Start Log in");
        log.info("Logo is present");
    }

    @Test
    public void testCaseSelectProduct_CPI05() {

    }

    @Test
    public void testCaseOrder_CPI06() {

    }

    @Test(description = "test log out Mikuyta", priority = 2, dataProviderClass = Data.class, dataProvider = "logoutdata")
    public void testCaseLogout_CPI07(User user) {
        log.info("Get Home Page");
        log.info("Do Log out");
    }
}
