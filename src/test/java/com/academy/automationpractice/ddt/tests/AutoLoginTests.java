package com.academy.automationpractice.ddt.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AutoLoginTests extends BaseTest {
    @Ignore
    @Test
    public void loginAndCloseBrowser() {
        manager.goTo().home();
        manager.session().login();
    }


    @Test(dataProvider = "autoLoginProvider")
    public void testAutoLogin(String userNameExpected) {
        manager.goTo().home();
//        manager.session().login();

        manager.verify().userIsLoggedIn(userNameExpected);
//        manager.session().logout();
    }

    // TODO move user
    @DataProvider(name="autoLoginProvider")
    private Object[][] authProvider() {
        return new Object[][]{
                {"OLEG AFANASIEV"}
        };
    }
}
