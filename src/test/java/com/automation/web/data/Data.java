package com.automation.web.data;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Data provider class.
 * @author feliciti huarancca
 */
public class Data {

    @DataProvider(name = "logindata")
    public Object[][] loginData() {
        return new Object[][] {{new User()}};
    }

    @DataProvider(name = "logoutdata")
    public Object[][] logoutdata() {
        return new Object[][] {{"licity", "licity22"}};
    }

    @DataProvider(name = "canceldata")
    public Object[][] canceldata() {
        return new Object[][] {{new User()}};
    }

    @DataProvider(name = "registerdata")
    public Object[][] registerdata() {
        return new Object[][] {{new User()}};
    }

}
